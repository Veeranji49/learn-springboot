package com.example.controller.OneToMany;

import com.example.entity.OneToMany.Post;
import com.example.service.OneToMany.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/save-post", method = RequestMethod.POST)
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post p = postService.savePost(post);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get-all-posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> list = postService.getAllPosts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-one-post/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post p = postService.getPostById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/update-post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post p = postService.updatePost(post, id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "delete-post/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}