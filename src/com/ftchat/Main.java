package com.ftchat;

import com.ftchat.post.Post;
import com.ftchat.post.PostDaoImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        PostDaoImpl postDao = new PostDaoImpl();
        List<Post> posts = postDao.getAllPosts();

        for (Post post : posts) System.out.println(post.toString());
    }
}