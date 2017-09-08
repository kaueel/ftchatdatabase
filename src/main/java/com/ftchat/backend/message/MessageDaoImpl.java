package com.ftchat.backend.message;

import com.ftchat.backend.dao.DaoOwner;
import com.ftchat.backend.user.User;
import com.ftchat.backend.user.UserDaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.squareup.okhttp.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MessageDaoImpl extends DaoOwner implements MessageDao {
    private final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");
    private final String SEND_MESSAGE_URL = "https://us-central1-copper-index-179013.cloudfunctions.net/sendMessage";

    @Override
    public List<Message> getAllMessagesFromChat(int sender, int receiver) throws Exception {
        ArrayList<Map<String, String>> preMessages =
                this.executeQueryWithGoogleCloud("call GetMessages(" + Integer.toString(sender) + ", " + Integer.toString(receiver) + ");");

        List<Message> response = new ArrayList<>();

        preMessages.forEach((Map<String, String> messageRow) -> {
            Message message = new Message(
                    Integer.parseInt(messageRow.get("id")),
                    Integer.parseInt(messageRow.get("sender")),
                    Integer.parseInt(messageRow.get("receiver")),
                    messageRow.get("content"),
                    messageRow.get("send_date")

            );
            response.add(message);
        });

        return response;
    }

    @Override
    public List<Message> getMessagesSentAfterAId(int sender, int receiver, int id) throws Exception {
        ArrayList<Map<String, String>> preMessages =
                this.executeQueryWithGoogleCloud("CALL GetMessagesAfterAId (" + Integer.toString(sender) + ", "
                        + Integer.toString(receiver) + ", " + Integer.toString(id) + ");");

        List<Message> response = new ArrayList<>();

        preMessages.forEach((Map<String, String> messageRow) -> {
            Message message = new Message(
                    Integer.parseInt(messageRow.get("id")),
                    Integer.parseInt(messageRow.get("sender")),
                    Integer.parseInt(messageRow.get("receiver")),
                    messageRow.get("content"),
                    messageRow.get("send_date")

            );
            response.add(message);
        });

        return response;
    }

    @Override
    public Message sendMessage(Message message) throws Exception {
        ArrayList<Map<String, String>> preId =
                this.executeQueryWithGoogleCloud("CALL AddMessage (" + Integer.toString(message.getSender()) +
                        ", " + Integer.toString(message.getReceiver()) +
                        ", '" + message.getContent() + "');");

        return new Message(
                Integer.parseInt(preId.get(0).get("id")),
                message.getSender(),
                message.getReceiver(),
                message.getContent(),
                preId.get(0).get("send_date")
        );
    }

    @Override
    public Message sendMessageWithLambdaFunction(Message message) throws Exception {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("sender", message.getSender());
        jsonObject.addProperty("receiver", message.getReceiver());
        jsonObject.addProperty("content", message.getContent());

        RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, new Gson().toJson(jsonObject));

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(SEND_MESSAGE_URL)
                .post(requestBody)
                .addHeader("content-type", "application/json")
                .build();

        Response response = client.newCall(request).execute();

        String res = response.body().string();
        JsonArray responseJson = new Gson().fromJson(res, JsonArray.class);
        JsonElement newIdInserted = responseJson.get(0);
        JsonElement newDateInserted = responseJson.get(1);

        return new Message(
                newIdInserted.getAsJsonObject().get("value").getAsInt(),
                message.getSender(),
                message.getReceiver(),
                message.getContent(),
                newDateInserted.getAsJsonObject().get("value").getAsString()
        );
    }

    @Override
    public boolean deleteMessage(Message message) throws Exception {
        ArrayList<Map<String, String>> preRowsModified =
                this.executeQueryWithGoogleCloud("CALL DeleteMessage (" + Integer.toString(message.getId()) + ");");
        if (Integer.parseInt(preRowsModified.get(0).get("rows_count")) > 0)
            return true;
        else throw new Exception("dbNotFound");
    }

    @Override
    public String exportMessages(int sender, int receiver) throws Exception {
        List<Message> messages = this.getAllMessagesFromChat(sender, receiver);

        if (!messages.isEmpty()) {
            UserDaoImpl userDao = new UserDaoImpl();
            User userBySender = userDao.getUserById(sender);
            User userByReceiver = userDao.getUserById(receiver);
            try {
                Random rand = new Random();
                String filename = "export" + Integer.toString(rand.nextInt(Integer.MAX_VALUE)) + ".txt";
                PrintWriter writer = new PrintWriter(filename, "UTF-8");

                messages.forEach(message -> {
                    if (message.getSender() == sender)
                        writer.println(userBySender.getName() + ": " + message.getContent() + " -" + message.getDate());
                    else
                        writer.println(userByReceiver.getName() + ": " + message.getContent() + " -" + message.getDate());
                });

                writer.close();

                return filename;
            } catch (IOException ioe) {
                System.out.println("IOException");
            }
        } else {
            throw new Exception("noMessagesToExport");
        }

        return null;
    }

    @Override
    public boolean deleteExportFile(String filename) throws Exception {
        return new File(filename).delete();
    }
}
