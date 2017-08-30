package com.ftchat;

import com.ftchat.user.User;
import com.ftchat.user.UserDaoImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.getAllUsers();

        for (User user : users) System.out.println(user.toString());

        System.out.println("----- TESTES DE USUARIO UNITARIO -----");

        User testUser = userDao.createUser("test", "123");
        System.out.println(testUser.toString());

        try {
            userDao.authUser(testUser.getName(), "123");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        try {
            System.out.println(userDao.getUserById(testUser.getId()).toString());
        } catch (Exception e) {
            if (e.getMessage().equals("dbNotFound"))
                System.out.println("User not found");
            else
                System.out.println("Unhandled exception");
        }

        try {
            System.out.println(userDao.getUserByName(testUser.getName()).toString());
        } catch (Exception e) {
            if (e.getMessage().equals("dbNotFound"))
                System.out.println("User not found");
            else
                System.out.println("Unhandled exception");
        }

        testUser.setName("testUpdated");

        userDao.updateUser(testUser);

        try {
            userDao.deleteUser(testUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}