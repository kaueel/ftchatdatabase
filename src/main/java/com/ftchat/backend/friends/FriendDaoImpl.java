package com.ftchat.backend.friends;

import com.ftchat.backend.dao.DaoOwner;
import com.ftchat.backend.serializable.SerializableObject;
import com.ftchat.backend.user.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FriendDaoImpl extends DaoOwner implements FriendDao{

    public FriendDaoImpl(Connection conn) { super(conn); }

    public FriendDaoImpl() {
        super();
    }

    @Override
    public List<Friend> getAllFriends(User user) throws Exception {
        List<Friend> response = null;
        ArrayList<SerializableObject> preUsers = this.executeFtpGet("friends"+user.getName());
        if(preUsers != null) {
            response= (List<Friend>) (ArrayList<?>) preUsers;
        }
        return response;
    }

    @Override
    public Friend addFriend(User user,User friend) throws Exception {
        try {
            this.executeFtpInsert("friends"+user.getName(),new Friend(friend));
            this.executeFtpInsert("friends"+friend.getName(),new Friend(user));
            return new Friend(friend);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("dbUpdateFail");
        }
    }

    @Override
    public Friend verifyFriend(int user_primary, int user_secondary) throws Exception {
        try {
            ArrayList<Map<String, String>> preFriend = this.executeQuery("select user_primary from [friend] where user_primary ='" + user_primary + "' and user-secondary ='"+ user_secondary +"'");
            return null;
        } catch (Exception e) {
            throw new Exception("verifyFail");
        }
    }

    @Override
    public boolean deleteFriend(Friend friend) throws Exception {
        try {
//            if (this.executeUpdate("delete from [friend] where user_secondary =" + Integer.toString(friend.getUser_secondary())) == 0)
//                throw new Exception("dbNotFound");
//            else return true;
            return  false;
        } catch (Exception e) {
            throw new Exception("dbUpdateFail");
        }
    }

}
