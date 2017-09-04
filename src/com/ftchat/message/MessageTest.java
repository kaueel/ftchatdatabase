package com.ftchat.message;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("01/01/2017");
        List<Message> messages = messageDao.getMessagesSentAfterAId(1, 2, 1);

        assertNotNull(messages);
        assertThat(messages, not(IsEmptyCollection.empty()));
    }

    @Test
    public void createMessage() throws Exception {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        Message message = new Message(1, 2, "test");
        messageDao.sendMessage(message);

        assertNotSame(message.getId(), 0);

        messageDao.deleteMessage(message);
    }

    @Test
    public void deleteMessage() throws Exception {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        Message message = new Message(1, 2, "test");
        messageDao.sendMessage(message);

        assertTrue(messageDao.deleteMessage(message));
    }
}
