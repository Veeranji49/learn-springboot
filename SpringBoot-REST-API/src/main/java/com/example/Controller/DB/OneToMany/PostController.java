package com.example.Controller.DB.OneToMany;

import com.example.Entity.DB.OneToMany.Post;
import com.example.Service.DB.OneToMany.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @PostMapping(value="/save-post")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        Post p = postService.savePost(post);
        logger.info("MethodName: {}", "addPost", "Post: {}", post);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping(value="/getall-posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        logger.info("MethodName: {}", "getAllPosts", "Posts: {}", posts);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping(value="/getone-post/{id}")
    public ResponseEntity<Post> getOnePost(@PathVariable long id) {
        Post p = postService.getPostById(id);
        logger.info("MethodName: {}", "getOnePost", "id: {}", id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        postService.deletePost(id);
        logger.info("MethodName: {}", "deletePost", "id: {}", id);
        return new ResponseEntity<>("Post deleted", HttpStatus.OK);
    }

    @PutMapping(value="/update-post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable long id, @RequestBody Post post) {
        Post p = postService.updatePost(post, id);
        logger.info("MethodName: {}", "updatePost", "id: {}", id , "Post: {}", post);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    ////  Retrieving specific columns from the database  ////

    @GetMapping(value = "/getall-authors-titles")
    public ResponseEntity<List<String>> getAuthorsTitles(){
        List<String> authorsTitles = postService.findAuhorTitles();
        logger.info("MethodName: {}", "getAllAuthorsTitles", "Authors: {}", authorsTitles);
        return new ResponseEntity<>(authorsTitles, HttpStatus.OK);
    }

    @GetMapping(value="/getall-descriptions")
    public ResponseEntity<List<String>> getallDescriptions(){
        List<String> descriptions = postService.findDescriptions();
        logger.info("MethodName: {}", "getAllDescriptions", "Descriptions: {}", descriptions);
        return new ResponseEntity<>(descriptions, HttpStatus.OK);
    }
}
/*
{
  "title": "family",
  "description": "family is everything",
  "author": "veeru",
  "comments": [
    {
      "text": "family is love"
    },
    {
      "text": "family is care"
    }
  ]
}
 */
