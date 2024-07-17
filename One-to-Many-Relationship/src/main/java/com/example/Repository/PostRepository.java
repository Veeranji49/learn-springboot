package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
