package com.ftchat.post;

import com.ftchat.post.Post;

import java.util.List;

public interface PostDao {
    public List<Post> getAllPosts() throws Exception;
    public String getPost(int id);
    public void updatePost(Post post);
    public void deletePost(Post post);
}
