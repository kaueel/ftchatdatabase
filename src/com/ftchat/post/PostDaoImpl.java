package com.ftchat.post;

import com.ftchat.dao.DaoOwner;
import javafx.geometry.Pos;
import jdk.internal.cmm.SystemResourcePressureImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostDaoImpl extends DaoOwner implements PostDao {

    /**
     * Get all the posts from the post table
     */
    @Override
    public List<Post> getAllPosts() throws Exception {
        ArrayList<Map<String, String>> prePosts = this.executeQuery("select * from post");
        List<Post> response = new ArrayList<>();

        prePosts.forEach((Map<String, String> postRow) -> {
            Post post = new Post(
                    Integer.parseInt(postRow.get("id")),
                    postRow.get("title"),
                    postRow.get("subtitle"),
                    postRow.get("content"),
                    postRow.get("author")
            );
            response.add(post);
        });

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
