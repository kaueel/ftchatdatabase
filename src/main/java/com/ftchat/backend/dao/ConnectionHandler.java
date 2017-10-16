package com.ftchat.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHandler {
    private Connection googleChromeCloudConnectionInstance = null;
    private Connection azureConnectionInstance = null;

    public ConnectionHandler() throws Exception {
        this.azureConnectionInstance = this.getAzureConnection();
        //this.googleChromeCloudConnectionInstance = this.getGoogleCloudConnection();
    }

    private Connection getAzureConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        return DriverManager.getConnection("jdbc:sqlserver://ftchat.database.windows.net:1433;database=ftchatdb;" +
                "user=ftchat@ftchat;password=Rootadmin123;encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    }

    private Connection getGoogleCloudConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager
                .getConnection(String.format(
                        "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
                                + "socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
                        "ftchat",
                        "copper-index-179013:southamerica-east1:ftchatdatabase"), "root", "Rootadmin123");
    }

    public Connection getGoogleChromeCloudConnectionInstance() throws Exception {
        if (!this.googleChromeCloudConnectionInstance.isClosed()) {
            return this.googleChromeCloudConnectionInstance;
        } else {
            this.googleChromeCloudConnectionInstance = this.getGoogleCloudConnection();
            return this.googleChromeCloudConnectionInstance;
        }
    }

    public Connection getAzureConnectionInstance() throws Exception {
        if (!this.azureConnectionInstance.isClosed())
            return this.azureConnectionInstance;
        else
            return this.getAzureConnection();
    }
}
