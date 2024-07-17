package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Entity.Comment;
import com.example.Entity.Post;
import com.example.Repository.PostRepository;

@SpringBootApplication
public class OneToManyRelationshipApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OneToManyRelationshipApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Post post=new Post("Amazon Forest","Environment");
		
		Comment comment1=new Comment("protect the Environment");
		Comment comment2=new Comment("Dont do de-forestation");
		Comment comment3=new Comment("Save the Environment");
		
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		post.getComments().add(comment3);
		
		postRepository.save(post);
			
	}

}
