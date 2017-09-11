package com.ftchat.backend.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaoOwner {
    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DaoOwner(Connection conn){
        this.conn = conn;
    }

    protected ArrayList<Map<String, String>> executeQuery(String query) throws Exception {
        try {
            // Statements allow to issue SQL queries to the database
            statement = this.conn.createStatement();

            // Result set get the result of the SQL query
            return this.prepareResponse(statement.executeQuery(query));
        } catch (Exception e) {
            System.out.println("dbConnectionError");
            throw e;
        } finally {
            //close();
        }
    }

    protected int executeUpdate(String query) throws Exception {
        try {

            statement = this.conn.createStatement();
            int effectedRows = statement.executeUpdate(query);
            if (effectedRows > 0)
                return effectedRows;
            else throw new Exception("dbUpdateFail");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("dbConnectionError");
            throw e;
        } finally {
            //close();
        }
    }

    private ArrayList<Map<String, String>> prepareResponse(ResultSet resultSet) throws Exception{
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

        return response;
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

            if (this.conn != null) {
                this.conn.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (Exception e) {
            System.out.println("Houve um erro ao finalizar a conexão ao banco de dados");
        }
    }

    public Connection getConn() {
        return conn;
    }

}