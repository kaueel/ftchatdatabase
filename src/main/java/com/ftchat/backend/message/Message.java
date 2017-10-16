package com.ftchat.backend.message;

public class Message {
    private int id;
    private int sender;
    private int receiver;
    private String content;
    private String date;

    public Message(int id, int sender, int receiver, String content, String date) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.date = date;
    }

    public Message(int sender, int receiver, String content) {
        this.id = 0;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getSender() {
        return sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';

    }
}
