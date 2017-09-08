package com.ftchat.backend.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaoOwner {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    protected ArrayList<Map<String, String>> executeQuery(String query) throws Exception {
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

            ArrayList<Map<String, String>> response = new ArrayList<>();
            String columnName;

            while (resultSet.next()) {
                int columns = resultSet.getMetaData().getColumnCount();
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= columns; i++) {
                    columnName = resultSet.getMetaData().getColumnName(i);
                    row.put(columnName, resultSet.getString(i));
                }
                response.add(row);
            }

            //Return the resultSet
            return response;
        } catch (Exception e) {
            System.out.println("dbConnectionError");
            throw e;
        } finally {
            close();
        }
    }

    protected int executeUpdate(String query) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:sqlserver://ftchat.database.windows.net:1433;database=ftchatdb;" +
                            "user=ftchat@ftchat;password=Rootadmin123;encrypt=true;trustServerCertificate=false;" +
                            "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

            statement = connect.createStatement();
            int effectedRows = statement.executeUpdate(query);
            if (effectedRows > 0)
                return effectedRows;
            else throw new Exception("dbUpdateFail");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("dbConnectionError");
            throw e;
        } finally {
            close();
        }
    }

    protected ArrayList<Map<String, String>> executeQueryWithGoogleCloud(String query) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcUrl = String.format(
                    "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
                            + "socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
                    "ftchat",
                    "copper-index-179013:southamerica-east1:ftchatdatabase");

            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(jdbcUrl, "root", "Rootadmin123");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);

            ArrayList<Map<String, String>> response = new ArrayList<>();
            String columnName;

            while (resultSet.next()) {
                int columns = resultSet.getMetaData().getColumnCount();
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= columns; i++) {
                    columnName = resultSet.getMetaData().getColumnName(i);
                    row.put(columnName, resultSet.getString(i));
                }
                response.add(row);
            }

            //Return the resultSet
            return response;
        } catch (Exception e) {
            System.out.println("dbConnectionError");
            throw e;
        } finally {
            close();
        }
    }

    protected int executeUpdateWithGoogleCloud(String query) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcUrl = String.format(
                    "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
                            + "socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
                    "ftchat",
                    "copper-index-179013:southamerica-east1:ftchatdatabase");

            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection(jdbcUrl, "root", "Rootadmin123");

            statement = connect.createStatement();
            int effectedRows = statement.executeUpdate(query);
            if (effectedRows > 0)
                return effectedRows;
            else throw new Exception("dbUpdateFail");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("dbConnectionError");
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

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (Exception e) {
            System.out.println("Houve um erro ao finalizar a conexão ao banco de dados");
        }
    }

}