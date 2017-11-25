package com.ftchat.backend.friends;

import com.ftchat.backend.serializable.SerializableObject;
import com.ftchat.backend.user.User;


public class Friend extends SerializableObject {
    private int id;
    private User user;

    public Friend(int id,User user){
        this.id = id;
        this.user = user;
    }

    public Friend(User user){

        this.user= user;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }



    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", user=" + user + '\'' +
                '}';
    }
}
