package com.ftchat.backend.user;

import com.ftchat.backend.serializable.SerializableObject;

public class User extends SerializableObject {
    private int id;
    private String name;
    private String fullName;
    private String email;
    private String password;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(String name,String email,String fullName, String password) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
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

    public String getfullName() {
        return name;
    }

    public String getemail() {
        return name;
    }

    public boolean validPassword(String Password){
        return this.password.equals(Password);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
