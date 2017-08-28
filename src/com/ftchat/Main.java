package com.ftchat;

import com.ftchat.dao.DaoOwner;
import com.ftchat.post.PostDaoImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        PostDaoImpl post = new PostDaoImpl();
        post.getAllPosts();
    }
}
