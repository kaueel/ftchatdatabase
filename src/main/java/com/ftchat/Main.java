package com.ftchat;

import com.ftchat.message.Message;
import com.ftchat.message.MessageDao;
import com.ftchat.message.MessageDaoImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        Message message = new Message(1, 2, "teste em java");
        System.out.println(messageDao.sendMessageWithLambdaFunction(message).toString());
    }
}