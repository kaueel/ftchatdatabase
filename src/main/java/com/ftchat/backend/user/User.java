package com.ftchat.backend.user;

import com.ftchat.backend.serializable.SerializableObject;

public class User extends SerializableObject {
    private int id;
    private String name;
    private String password;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() { }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
