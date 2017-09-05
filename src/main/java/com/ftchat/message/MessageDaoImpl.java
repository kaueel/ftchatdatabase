package com.ftchat.message;

import com.ftchat.dao.DaoOwner;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.squareup.okhttp.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageDaoImpl extends DaoOwner implements MessageDao {
    private final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");
    private final String SEND_MESSAGE_URL = "https://us-central1-copper-index-179013.cloudfunctions.net/sendMessage";

    @Override
    public List<Message> getAllMessagesFromChat(int sender, int receiver) throws Exception {
        ArrayList<Map<String, String>> preMessages =
                this.executeQuery("select id,content,send_date from [message] where sender =" + Integer.toString(sender) +
                        "and receiver =" + Integer.toString(receiver));

        List<Message> response = new ArrayList<>();

        preMessages.forEach((Map<String, String> messageRow) -> {
            Message message = new Message(
                    Integer.parseInt(messageRow.get("id")),
                    sender,
                    receiver,
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
                this.executeQuery("select id,content,send_date from [message] where sender =" + Integer.toString(sender) +
                        "and receiver =" + Integer.toString(receiver) +
                        "and id >" + Integer.toString(id));

        List<Message> response = new ArrayList<>();

        preMessages.forEach((Map<String, String> messageRow) -> {
            Message message = new Message(
                    Integer.parseInt(messageRow.get("id")),
                    sender,
                    receiver,
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
                this.executeQuery("EXEC AddMessage @sender =" + Integer.toString( message.getSender() ) +
                        ", @receiver =" + Integer.toString( message.getReceiver() ) +
                        ", @content = '" + message.getContent() + "'");

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
        if (this.executeUpdate("delete from [message] where id =" + Integer.toString(message.getId())) == 0)
            throw new Exception("dbNotFound");
        else return true;
    }
}
