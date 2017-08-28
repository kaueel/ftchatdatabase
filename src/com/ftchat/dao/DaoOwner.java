package com.ftchat.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoOwner {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    protected ArrayList executeQuery(String query) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:sqlserver://ftchat.database.windows.net:1433;database=ftchatdb;" +
                            "user=ftchat@ftchat;password=Rootadmin123;encrypt=true;trustServerCertificate=false;" +
                            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);

            ArrayList response = new ArrayList<>();

            while (resultSet.next()){
                int columns = resultSet.getMetaData().getColumnCount();
                ArrayList row = new ArrayList<>();
                for (int i = 1; i <= columns; i++)
                    row.add(resultSet.getString(i));
                response.add(row);
            }

            //Return the resultSet
            return response;
        } catch (Exception e) {
            System.out.println("Houve um erro ao efetuar conexão ao banco de dados");
            throw e;
        } finally {
            close();
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println("Houve um erro ao finalizar a conexão ao banco de dados");
        }
    }

}