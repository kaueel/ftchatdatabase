package com.ftchat.backend.friends;

import com.ftchat.backend.user.User;

import java.util.List;

public interface FriendDao {
    public List<Friend> getAllFriends(User user) throws Exception;
    public Friend addFriend(User user,User friend) throws Exception;
    public Friend verifyFriend(int user_primary, int user_secondary) throws Exception;
    public boolean deleteFriend(Friend friend) throws Exception;
}
