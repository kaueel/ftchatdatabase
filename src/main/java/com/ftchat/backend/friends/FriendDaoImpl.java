package com.ftchat.backend.friends;

import com.ftchat.backend.dao.DaoOwner;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FriendDaoImpl extends DaoOwner implements FriendDao{

    public FriendDaoImpl(Connection conn) { super(conn); }

    @Override
    public List<Friend> getAllFriends() throws Exception{
        ArrayList<Map<String, String>> preFriends = this.executeQuery("select id, user_primary, user_secondary from [friend]");
        List<Friend> response = new ArrayList<>();

        preFriends.forEach((Map<String, String> friendsRow) -> {
            Friend friend = new Friend(
                    Integer.parseInt(friendsRow.get("id")),
                    Integer.parseInt(friendsRow.get("user_primary")),
                    Integer.parseInt(friendsRow.get("user_secondary")));
            response.add(friend);
        });

        return response;
    }

    @Override
    public Friend addFriend(int user_primary, int user_secondary) throws Exception {
        try {
            ArrayList<Map<String, String>> preFriend = this.executeQuery("EXEC AddFriend @user_primary = '" + user_primary + "', @user_secondary = '" + user_secondary + "'");
            return new Friend(Integer.parseInt(preFriend.get(0).get("id")), user_primary, user_secondary);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("dbUpdateFail");
        }
    }

    @Override
    public Friend verifyFriend(int user_primary, int user_secondary) throws Exception {
        try {
            ArrayList<Map<String, String>> preFriend = this.executeQuery("select user_primary from [friend] where user_primary ='" + user_primary + "' and user-secondary ='"+ user_secondary +"'");
            return new Friend(Integer.parseInt(preFriend.get(0).get("id")), user_primary, user_secondary);
        } catch (Exception e) {
            throw new Exception("verifyFail");
        }
    }

    @Override
    public boolean deleteFriend(Friend friend) throws Exception {
        try {
            if (this.executeUpdate("delete from [friend] where user_secondary =" + Integer.toString(friend.getUser_secondary())) == 0)
                throw new Exception("dbNotFound");
            else return true;
        } catch (Exception e) {
            throw new Exception("dbUpdateFail");
        }
    }

}
