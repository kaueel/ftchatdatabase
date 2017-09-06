package com.ftchat.message;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class MessageTest {
    @Test
    public void getAllMessagesFromAChat() throws Exception {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        List<Message> messages = messageDao.getAllMessagesFromChat(1, 2);

        assertNotNull(messages);
        assertThat(messages, not(IsEmptyCollection.empty()));
    }

    @Test
    public void getMessagesSentAfterADate() throws Exception {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        List<Message> messages = messageDao.getMessagesSentAfterAId(1, 2, 1);

        assertNotNull(messages);
        assertThat(messages, not(IsEmptyCollection.empty()));
    }

    @Test
    public void sendMessage() throws Exception {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        Message message = messageDao.sendMessage(new Message(1, 2, "test"));
        assertNotSame(message.getId(), 0);

        messageDao.deleteMessage(message);
    }

    @Test
    public void sendMessageWithLambdaFunction() throws Exception {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        Message message = messageDao.sendMessageWithLambdaFunction(new Message(1, 2, "test"));
        assertNotSame(message.getId(), 0);

        messageDao.deleteMessage(message);
    }

    @Test
    public void deleteMessage() throws Exception {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        Message message = messageDao.sendMessage(new Message(1, 2, "test"));

        assertTrue(messageDao.deleteMessage(message));
    }

    @Test
    public void exportMessages() throws Exception{
        MessageDaoImpl messageDao = new MessageDaoImpl();
        String filename = messageDao.exportMessages(1, 2);

        assertNotNull(filename);

        messageDao.deleteExportFile(filename);
    }
}
