package com.ftchat.backend.user;

import com.ftchat.backend.dao.DaoOwner;
import com.ftchat.backend.serializable.SerializableObject;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends DaoOwner implements UserDao {

    public UserDaoImpl(Connection conn) {
        super(conn);
    }

    public UserDaoImpl() {
        super();
    }

    /**
     * Get all the posts from the user table
     */
    @Override
    public List<User> getAllUsers() throws Exception {
        List<User> response = null;
        ArrayList<SerializableObject> preUsers = this.executeFtpGet("users");
        if(preUsers != null) {
            response= (ArrayList<User>) (ArrayList<?>) preUsers;
        }
        return response;
    }

    @Override
    public User createUser(String name, String password) throws Exception {
        try {
            User user = new User(name,password);
            user = (User)this.executeFtpInsert("users",user);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("dbUpdateFail");
        }
    }

    @Override
    public User authUser(String name, String password) throws Exception {
        try {
            ArrayList<Map<String, String>> preUser = this.executeQuery("EXEC SelectUser @name = '" + name + "', @password = '" + password + "'");
            return new User(Integer.parseInt(preUser.get(0).get("id")), name);
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
            ArrayList<Map<String, String>> preUser = this.executeQuery("select id from [user] where name ='" + name + "'");
            return new User(Integer.parseInt(preUser.get(0).get("id")), name);
        } catch (Exception e) {
            throw new Exception("dbNotFound");
        }
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        try {
            int effectedRows = this.executeUpdate("update [user] set name = '" + user.getName() + "' where id = " + Integer.toString(user.getId()));
            if (effectedRows > 0)
                return true;
            else throw new Exception("dbNotFound");
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
