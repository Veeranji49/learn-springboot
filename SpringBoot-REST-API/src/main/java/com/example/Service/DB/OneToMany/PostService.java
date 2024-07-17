package com.example.Service.DB.OneToMany;

import com.example.Entity.DB.OneToMany.Post;

import java.util.List;

public interface PostService {

    public Post savePost(Post post);
    public Post getPostById(long id);
    public List<Post> getAllPosts();
    public void deletePost(long id);
    public Post updatePost(Post post, long id);
    public List<String> findAuhorTitles();
    public List<String> findDescriptions();
}
