package com.ftchat.backend.dao;

import com.ftchat.backend.serializable.SerializableObject;
import com.sun.corba.se.pept.encoding.OutputObject;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;

import java.io.*;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DaoOwner {
    private Connection conn = null;
    private FTPClient ftpConnection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DaoOwner(Connection conn) {
        this.conn = conn;
    }

    public DaoOwner(FTPClient ftpConnection) {
        this.ftpConnection = ftpConnection;
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

    private ArrayList<Map<String, String>> prepareResponse(ResultSet resultSet) throws Exception {
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

    public ArrayList<SerializableObject> executeFtpGet(String filename) throws Exception {
        try {
            ArrayList<SerializableObject> response = new ArrayList<>();
            this.ftpConnection.setFileType(this.ftpConnection.BINARY_FILE_TYPE);
            InputStream fileInputStream = this.ftpConnection.retrieveFileStream(filename + ".txt");

            try {
                ObjectInputStream fileToObjectStream = new ObjectInputStream(fileInputStream);
                response = (ArrayList<SerializableObject>) fileToObjectStream.readObject();
                fileToObjectStream.close();
            } catch (EOFException e) {
            }

            fileInputStream.close();
            this.ftpConnection.completePendingCommand();

            return response;
        } catch (FTPConnectionClosedException e) {
            throw e;
        }
    }

    public SerializableObject executeFtpInsert(String filename, SerializableObject objectToInsert) throws Exception {
        if (!this.fileExists(filename + ".txt"))
            this.executeFtpCreate(filename);

        ArrayList<SerializableObject> objectList = this.executeFtpGet(filename);
        objectList.add(objectToInsert);
        this.ftpConnection.setFileType(this.ftpConnection.BINARY_FILE_TYPE);
        OutputStream fileOutputStream = this.ftpConnection.storeFileStream(filename + ".txt");
        System.out.println(Arrays.toString(this.ftpConnection.getReplyStrings()));
        ObjectOutputStream objectToFileStream = new ObjectOutputStream(fileOutputStream);
        objectToFileStream.writeObject(objectList);
        objectToFileStream.close();
        fileOutputStream.close();
        this.ftpConnection.completePendingCommand();
        return objectToInsert;
    }

    public boolean executeFtpCreate(String filename) throws Exception {
        if (this.fileExists(filename + ".txt"))
            return true;

        File firstLocalFile = new File(filename + ".txt");
        if (firstLocalFile.createNewFile()) {
            String firstRemoteFile = filename + ".txt";
            InputStream inputStream = new FileInputStream(firstLocalFile);
            boolean status = this.ftpConnection.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            //this.ftpConnection.completePendingCommand();
            boolean statusDeleted = firstLocalFile.delete();
            return (status && statusDeleted);
        } else
            throw new Exception("Not able to create a new local file ");
    }

    public boolean fileExists(String filename) throws Exception {
        boolean fileExists = !((this.ftpConnection.retrieveFileStream(filename) == null) || (this.ftpConnection.getReplyCode() == 550));
        if (fileExists)
            this.ftpConnection.completePendingCommand();
        return fileExists;
    }

    public Map<String, String> parseLine(String information) {
        String[] lineMappedInArray = information.split(":");
        Map<String, String> lineMappedInMap = new HashMap<>();
        lineMappedInMap.put(lineMappedInArray[0], lineMappedInArray[1]);
        return lineMappedInMap;
    }
}