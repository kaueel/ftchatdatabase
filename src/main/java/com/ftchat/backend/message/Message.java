package com.ftchat.backend.message;

import com.ftchat.backend.serializable.SerializableObject;
import com.ftchat.backend.user.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

public class Message extends SerializableObject {
    private int id;
    private String sender;
    private String content;
    private TemporalAccessor date;

    public Message( String sender, String content, TemporalAccessor date) {
        this.sender = sender;
        this.content = content;
        this.date = date;
    }

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.date = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }


    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TemporalAccessor getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';

    }
}
