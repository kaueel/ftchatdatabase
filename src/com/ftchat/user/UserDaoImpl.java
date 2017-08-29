package com.ftchat.user;

import com.ftchat.dao.DaoOwner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends DaoOwner implements UserDao {

    /**
     * Get all the posts from the user table
     */
    @Override
    public List<User> getAllUsers() throws Exception {
        ArrayList<Map<String, String>> preUsers = this.executeQuery("select id, name from [user]");
        List<User> response = new ArrayList<>();

        preUsers.forEach((Map<String, String> userRow) -> {
            User user = new User(
                    Integer.parseInt(userRow.get("id")),
                    userRow.get("name")
            );
            response.add(user);
        });

        return response;
    }

    public User createUser(String name, String password) throws Exception {
        try {
            int userId = this.executeUpdate("EXEC AddUser @name = '" + name + "', @password = '" + password + "'");
            if (userId <= 0)
                throw new Exception("dbUpdateFail");
            else return new User(userId, name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("dbUpdateFail");
        }
    }

    public User authUser(String name, String password) throws Exception {
        try {
            ArrayList<Map<String, String>> preUser = this.executeQuery("EXEC SelectUser @name = '" + name + "', @password = " + password + "'");
            return new User(Integer.parseInt(preUser.get(0).get("id")), name, password);
        } catch (Exception e) {
            throw new Exception("authFail");
        }
    }

    @Override
    public User getUserById(int id) throws Exception {
        try {
            ArrayList<Map<String, String>> preUser = this.executeQuery("select name from [user] where id =" + Integer.toString(id));
            return new User(id, preUser.get(0).get("name"));
        } catch (Exception e) {
            throw new Exception("dbNotFound");
        }
    }

    @Override
    public User getUserByName(String name) throws Exception {
        try {
            ArrayList<Map<String, String>> preUser = this.executeQuery("select id from [user] where name =" + name);
            return new User(Integer.parseInt(preUser.get(0).get("id")), name);
        } catch (Exception e) {
            throw new Exception("dbNotFound");
        }
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        try {
            if (this.executeUpdate("update [user] set name = '" + user.getName() + "' where id = " + Integer.toString(user.getId())) == 0)
                throw new Exception("dbNotFound");
            else return true;
        } catch (Exception e) {
            throw new Exception("dbUpdateFail");
        }
    }

    @Override
    public boolean deleteUser(User user) throws Exception {
        try {
            if (this.executeUpdate("delete from [user] where id =" + Integer.toString(user.getId())) == 0)
                throw new Exception("dbNotFound");
            else return true;
        } catch (Exception e) {
            throw new Exception("dbUpdateFail");
        }
    }
}
