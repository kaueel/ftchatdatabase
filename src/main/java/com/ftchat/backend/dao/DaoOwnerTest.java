package com.ftchat.backend.dao;

import com.ftchat.backend.message.Message;
import com.ftchat.backend.serializable.SerializableObject;
import org.apache.commons.net.ftp.FTPClient;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class DaoOwnerTest {
    private FTPClient conn = null;
    private DaoOwner dao = null;

    @Before
    public void createConnection() throws Exception {
        this.conn = new ConnectionHandler().getFtpConnectionInstance();
        this.dao = new DaoOwner();
    }

    @Test
    public void readInformationTest() throws Exception {
        ArrayList<SerializableObject> information = this.dao.executeFtpGet("test");
        System.out.println(information.toString());
        assertNotNull(information);
        assertThat(information, not(IsEmptyCollection.empty()));
        this.conn.disconnect();
    }

    @Test
    public void insertInformationTest() throws Exception {
        Message message = new Message(1, 2, 3, "ola, tudo bem???", "04/09/1997");
        assertEquals(this.dao.executeFtpInsert("test", message), message);
        this.conn.disconnect();
    }

    @Test
    public void createFileTest() throws Exception {
        assertTrue(this.dao.executeFtpCreate("testForAutomatedTests"));
        this.conn.disconnect();
    }
}
