package com.ftchat.friend;

public class Friend {
    private int id;
    private int user_primary;
    private int user_secondary;

    public Friend(int id,int user_primary, int user_secondary){
        this.id = id;
        this.user_primary = user_primary;
        this.user_secondary = user_secondary;
    }

    public int getId() {
        return id;
    }

    public int getUser_primary() {
        return user_primary;
    }

    public int getUser_secondary() {
        return user_secondary;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", user_primary=" + user_primary +
                ", user_secondary=" + user_secondary + '\'' +
                '}';
    }
}
