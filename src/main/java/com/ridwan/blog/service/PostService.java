package com.ridwan.blog.service;

import com.ridwan.blog.model.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post);

    Post updatePost(Post post);

    void deletePost(Post post);

    Post getPostById(Long Id);

    List<Post> getAllPosts();

    Post createComment(Post post);
}
