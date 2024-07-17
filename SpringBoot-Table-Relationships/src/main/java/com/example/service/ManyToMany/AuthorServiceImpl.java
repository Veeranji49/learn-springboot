package com.example.service.ManyToMany;

import com.example.entity.ManyToMany.Author;
import com.example.repository.ManyToMany.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
}
