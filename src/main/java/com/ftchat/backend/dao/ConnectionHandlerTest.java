package com.ftchat.backend.dao;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.*;

public class ConnectionHandlerTest {
    private ConnectionHandler conn = null;

    @Before
    public void createConnection() throws Exception {
        this.conn = new ConnectionHandler();
    }

    @Test
    public void getNewAzureConnection() throws Exception {
        Connection azureConnectionTest = this.conn.getAzureConnectionInstance();
        assertTrue(!azureConnectionTest.isClosed());
        azureConnectionTest.close();
    }

    @Test
    public void getNewFtpConnection() throws Exception {
        FTPClient ftpConnectionTest = this.conn.getFtpConnectionInstance();
        assertTrue(ftpConnectionTest.isConnected());
        ftpConnectionTest.disconnect();
    }

}
