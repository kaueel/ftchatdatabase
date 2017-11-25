package com.ftchat.backend.message;

import com.ftchat.backend.user.User;

import java.util.List;

public interface MessageDao {
    public List<Message> getAllMessagesFromChat(User sender, User receiver) throws Exception;
    public Message sendMessage(Message message,User sender, User receive) throws Exception;
    public Message sendMessageWithLambdaFunction(Message message) throws Exception;
    public boolean deleteMessage(Message message) throws Exception;
    public String exportMessages(int sender, int receiver) throws Exception;
    public boolean deleteExportFile(String filename) throws Exception;
}
