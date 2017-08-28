package com.ftchat.post;

import com.ftchat.dao.DaoOwner;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl extends DaoOwner implements PostDao {

    @Override
    public List<Post> getAllPosts() throws Exception {
        ArrayList prePosts = this.executeQuery("select * from post");

        prePosts.forEach(post -> System.out.println(post.toString()));

        List<Post> response = null;
        return response;
    }

    @Override
    public String getPost(int id) {
        return null;
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }
}
