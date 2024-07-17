package com.example.controller.ManyToMany;

import com.example.entity.ManyToMany.Author;
import com.example.service.ManyToMany.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(value = "/add-author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author author1 = authorService.addAuthor(author);
        return new ResponseEntity<>(author1, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getall-authors")
    public ResponseEntity<List<Author>> getall() {
        List<Author> list = authorService.getAllAuthors();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
