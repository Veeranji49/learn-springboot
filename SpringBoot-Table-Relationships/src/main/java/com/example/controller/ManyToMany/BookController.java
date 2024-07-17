package com.example.controller.ManyToMany;

import com.example.dto.ManyToMany.BookDTO;
import com.example.entity.ManyToMany.Book;
import com.example.service.ManyToMany.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping("/getall-books-authors")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("/add-book-authors")
    public ResponseEntity<Book> addBookAuthors(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.addBook(bookDTO), HttpStatus.OK);
    }

    @PutMapping("/update-authors-book/{id}")
    public ResponseEntity<Book> updateBookAuthor(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book book = bookService.updateBookAndAuthors(id, bookDTO);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/delete-book-authors/{id}")
    public ResponseEntity<String> deleteBookAndAuthors(@PathVariable Long id) {
        bookService.deleteBookAndAuthors(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/get-authors-books/{id}")
    public ResponseEntity<Book> getauthorsbooksbyId(@PathVariable long id) {
        Book book = bookService.getBookAuthorsById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
/*
    ///###  Post API   ###///
        http://localhost:9989/api/books/add-book-authors
    {
    "id": 5,
    "title": "play it my way",
    "authors": [
        {
            "id": 6,
            "name": "sachin tendulkar"
        }
    ]
}


    ///### Update API  ###///

        http://localhost:9989/api/books/update-authors-book/2
    {
    "id": 2,
    "title": "mahaprasthanam",
    "authors": [
        {
            "id": 8,
            "name": "sri sri Two"
        },
        {
            "id": 3,
            "name": "sri sri one"
        }
    ]
}



    ///###    Delete API  ###////

         http://localhost:9989/api/books/delete-book-authors/2


    ////#####  Retrieving All API  ###////
    http://localhost:9989/api/books/getall-books-authors


    ///###    Retrieving all book-author details  ###///
     http://localhost:9989/api/books/get-authors-books/4

     //###  Retrieving all author details   ###//
     http://localhost:9989/api/authors/getall-authors

 */