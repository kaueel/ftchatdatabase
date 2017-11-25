package com.ftchat.backend.friends;

import com.ftchat.backend.dao.ConnectionHandler;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class FriendTest {

    private Connection conn = null;

    @Before
    public void createConnection() throws Exception {
        this.conn = new ConnectionHandler().getAzureConnectionInstance();
    }

    @Test
    public void getAllFriends() throws Exception {
        FriendDaoImpl friendDao = new FriendDaoImpl(this.conn);
        //List<Friend> friends = friendDao.getAllFriends();

        //assertThat(friends, not(IsEmptyCollection.empty()));
    }

    @Test
    public void addFriend() throws Exception {
        FriendDaoImpl friendDao = new FriendDaoImpl(this.conn);
        //Friend friends = friendDao.addFriend(1, 2);

        //assertNotNull(friends);

        //friendDao.deleteFriend(friends);
    }

    @Test
    public void verifyFriend() throws Exception {
        FriendDaoImpl friendDao = new FriendDaoImpl(this.conn);
        //Friend friends = friendDao.verifyFriend(1, 2);

        //assertEquals((friends.getUser_secondary()),2);
    }

    @Test
    public void deleteFriend() throws Exception {
        FriendDaoImpl friendDao = new FriendDaoImpl(this.conn);
        //Friend friends = friendDao.addFriend(1, 2);

        //assertTrue(friendDao.deleteFriend(friends));
    }
}
