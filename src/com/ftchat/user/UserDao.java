package com.ftchat.user;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers() throws Exception;
    public User createUser(String name, String password) throws Exception;
    public User authUser(String name, String password) throws Exception;
    public User getUserById(int id) throws Exception;
    public User getUserByName(String name) throws Exception;
    public boolean updateUser(User user) throws Exception;
    public boolean deleteUser(User user) throws Exception;
}
