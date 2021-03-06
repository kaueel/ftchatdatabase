package com.ftchat.backend.user;

import com.ftchat.backend.dao.ConnectionHandler;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class UserTest {
    private Connection conn = null;

    @Before
    public void createConnection() throws Exception {
        this.conn = new ConnectionHandler().getAzureConnectionInstance();
    }

    @Test
    public void getUsers() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(this.conn);
        List<User> users = userDao.getAllUsers();

        assertThat(users, not(IsEmptyCollection.empty()));
    }

    @Test
    public void createUser() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(this.conn);
        User user = userDao.createUser("test", "123");

        assertEquals(user.toString(), (new User(user.getId(), "test")).toString());

        userDao.deleteUser(user);
    }

    @Test
    public void authUser() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(this.conn);
        User user = userDao.authUser("Admin", "123");

        assertEquals(user.toString(), (new User(user.getId(), "Admin")).toString());
    }

    @Test
    public void getUserById() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(this.conn);
        User user = userDao.getUserById(1);

        assertEquals(user.getName(), "Admin");
    }

    @Test
    public void getUserByName() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(this.conn);
        User user = userDao.getUserByName("Admin");

        assertEquals(user.getId(), 1);
    }

    @Test
    public void updateName() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(this.conn);

        User user = userDao.createUser("test", "123");
        user.setName("testUpdated");
        userDao.updateUser(user);

        assertEquals(user.getName(), "testUpdated");

        userDao.deleteUser(user);
    }

    @Test
    public void deleteUser() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(this.conn);
        User user = userDao.createUser("test", "123");

        assertTrue(userDao.deleteUser(user));
    }
}