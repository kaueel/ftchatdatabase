package com.ftchat.backend.message;

import java.util.List;

public interface MessageDao {
    public List<Message> getAllMessagesFromChat(int sender, int receiver) throws Exception;
    public List<Message> getMessagesSentAfterAId(int sender, int receiver, int id) throws Exception;
    public Message sendMessage(Message message) throws Exception;
    public Message sendMessageWithLambdaFunction(Message message) throws Exception;
    public boolean deleteMessage(Message message) throws Exception;
    public String exportMessages(int sender, int receiver) throws Exception;
    public boolean deleteExportFile(String filename) throws Exception;
}
