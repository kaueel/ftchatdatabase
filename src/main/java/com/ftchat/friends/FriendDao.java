package com.ftchat.friend;

import java.util.List;

public interface FriendDao {
    public List<> getAllFriends() throws Exception;
    public Friend addFriend(int user_primary, int user_secondary) throws Exception;
    public Friend verifyFriend
    public Friend verifyFriend(int user_primary, int user_secondary) throws Exception;
    public boolean deleteFriend(Friend friend) throws Exception;
}
