package com.example.service.OneToMany;

import com.example.entity.OneToMany.Post;
import com.example.repository.OneToMany.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Post post, long id) {
        Post p = postRepository.findById(id).get();
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setAuthor(post.getAuthor());
        p.setComments(post.getComments());
        return postRepository.save(p);
    }
}