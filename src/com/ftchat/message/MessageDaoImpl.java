package com.ftchat.message;

import com.ftchat.dao.DaoOwner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MessageDaoImpl extends DaoOwner implements MessageDao {
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
    public boolean deleteMessage(Message message) throws Exception {
        if (this.executeUpdate("delete from [message] where id =" + Integer.toString(message.getId())) == 0)
            throw new Exception("dbNotFound");
        else return true;
    }
}
