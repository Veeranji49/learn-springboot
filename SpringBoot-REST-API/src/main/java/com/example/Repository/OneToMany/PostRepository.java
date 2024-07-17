package com.example.Repository.OneToMany;

import com.example.Entity.DB.OneToMany.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT author,title FROM Post")
    List<String> findAllAuthorsTitles();

    @Query("SELECT description FROM Post")
    List<String> findAllDescriptions();
}
