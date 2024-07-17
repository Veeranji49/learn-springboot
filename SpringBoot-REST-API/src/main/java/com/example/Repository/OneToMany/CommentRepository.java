package com.example.Repository.OneToMany;

import com.example.Entity.DB.OneToMany.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
