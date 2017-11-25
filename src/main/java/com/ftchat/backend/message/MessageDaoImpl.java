package com.ftchat.backend.message;

import com.ftchat.backend.dao.ConnectionHandler;
import com.ftchat.backend.dao.DaoOwner;
import com.ftchat.backend.serializable.SerializableObject;
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
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MessageDaoImpl extends DaoOwner implements MessageDao {
    private final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");
    private final String SEND_MESSAGE_URL = "https://us-central1-copper-index-179013.cloudfunctions.net/sendMessage";

    public MessageDaoImpl(Connection conn) {
        super(conn);
    }

    public MessageDaoImpl() {
        super();
    }

    @Override
    public List<Message> getAllMessagesFromChat(User sender, User receiver) throws Exception {

        String file = "";

        if(sender.getName().compareToIgnoreCase(receiver.getName()) < 0){
            file = sender.getName()+"!#ftchar#!"+receiver.getName();
        }else{
            file = receiver.getName()+"!#ftchar#!"+sender.getName();
        }

        List<Message> response = null;
        ArrayList<SerializableObject> preUsers = this.executeFtpGet(file);
        if(preUsers != null) {
            response= (ArrayList<Message>) (ArrayList<?>) preUsers;
        }

        return response;
    }

    @Override
    public Message sendMessage(Message message,User sender, User receiver) throws Exception {

        String file;

        if(sender.getName().compareToIgnoreCase(receiver.getName()) < 0){
            file = sender.getName()+"!#ftchar#!"+receiver.getName();
        }else{
            file = receiver.getName()+"!#ftchar#!"+sender.getName();
        }

        return (Message) this.executeFtpInsert(file,message);

    }

    @Override
    public Message sendMessageWithLambdaFunction(Message message) throws Exception {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("sender", message.getSender());
//        jsonObject.addProperty("receiver", message.getReceiver());
//        jsonObject.addProperty("content", message.getContent());
//
//        RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, new Gson().toJson(jsonObject));
//
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url(SEND_MESSAGE_URL)
//                .post(requestBody)
//                .addHeader("content-type", "application/json")
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//        String res = response.body().string();
//        JsonArray responseJson = new Gson().fromJson(res, JsonArray.class);
//        JsonElement newIdInserted = responseJson.get(0);
//        JsonElement newDateInserted = responseJson.get(1);
//
//        return new Message(
//                newIdInserted.getAsJsonObject().get("value").getAsInt(),
//                message.getSender(),
//                message.getReceiver(),
//                message.getContent(),
//                newDateInserted.getAsJsonObject().get("value").getAsString()
//        );

    return null;
    }

    @Override
    public boolean deleteMessage(Message message) throws Exception {
        ArrayList<Map<String, String>> preRowsModified =
                this.executeQuery("CALL DeleteMessage (" + Integer.toString(message.getId()) + ");");
        if (Integer.parseInt(preRowsModified.get(0).get("rows_count")) > 0)
            return true;
        else throw new Exception("dbNotFound");
    }

    @Override
    public String exportMessages(int sender, int receiver) throws Exception {
//        List<Message> messages = this.getAllMessagesFromChat(sender, receiver);
//        Connection azureConnection = new ConnectionHandler().getAzureConnectionInstance();
//
//        if (!messages.isEmpty()) {
//            UserDaoImpl userDao = new UserDaoImpl(azureConnection);
//            User userBySender = userDao.getUserById(sender);
//            User userByReceiver = userDao.getUserById(receiver);
//            try {
//                Random rand = new Random();
//                String filename = "export" + Integer.toString(rand.nextInt(Integer.MAX_VALUE)) + ".txt";
//                PrintWriter writer = new PrintWriter(filename, "UTF-8");
//
//                messages.forEach(message -> {
//                    if (message.getSender() == sender)
//                        writer.println(userBySender.getName() + ": " + message.getContent() + " -" + message.getDate());
//                    else
//                        writer.println(userByReceiver.getName() + ": " + message.getContent() + " -" + message.getDate());
//                });
//
//                writer.close();
//
//                return filename;
//            } catch (IOException ioe) {
//                System.out.println("IOException");
//            }
//        } else {
//            throw new Exception("noMessagesToExport");
//        }

        return null;
    }

    @Override
    public boolean deleteExportFile(String filename) throws Exception {
        return new File(filename).delete();
    }
}
