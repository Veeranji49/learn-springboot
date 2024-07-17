package com.example.service.ManyToMany;

import com.example.dto.ManyToMany.BookDTO;
import com.example.entity.ManyToMany.Book;

import java.util.List;

public interface BookService {

    public Book addBook(BookDTO bookDTO);

    public List<Book> getAllBooks();

    public Book updateBookAndAuthors(Long id, BookDTO updatedBookDTO);

    public void deleteBookAndAuthors(Long id);

    public Book getBookAuthorsById(long id);

}
