package com.example.service.ManyToMany;

import com.example.entity.ManyToMany.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> getAllAuthors();

    public Author getAuthorById(Long id);

    public Author addAuthor(Author author);
}
