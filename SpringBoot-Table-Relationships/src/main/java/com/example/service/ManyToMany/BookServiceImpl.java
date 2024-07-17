package com.example.service.ManyToMany;

import com.example.dto.ManyToMany.AuthorDTO;
import com.example.dto.ManyToMany.BookDTO;
import com.example.entity.ManyToMany.Author;
import com.example.entity.ManyToMany.Book;
import com.example.repository.ManyToMany.AuthorRepository;
import com.example.repository.ManyToMany.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());

        Set<Author> authors = new HashSet<>();
        for (AuthorDTO authorDTO : bookDTO.getAuthors()) {
            Author author = new Author();
            author.setName(authorDTO.getName());
            author = authorRepository.save(author);
            authors.add(author);
        }

        book.setAuthors(authors);
        return bookRepository.save(book);
    }


    @Transactional
    public Book updateBookAndAuthors(Long id, BookDTO updatedBookDTO) {
        // Retrieve the book entity to update
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        // Update book details
        book.setTitle(updatedBookDTO.getTitle());

        // Update or add authors
        Set<Author> updatedAuthors = new HashSet<>();
        for (AuthorDTO authorDTO : updatedBookDTO.getAuthors()) {
            Author author;
            if (authorDTO.getId() != null) {
                // If author ID is provided, fetch existing author
                Optional<Author> optionalAuthor = authorRepository.findById(authorDTO.getId());
                if (optionalAuthor.isPresent()) {
                    author = optionalAuthor.get();
                    author.setName(authorDTO.getName());
                } else {
                    throw new RuntimeException("Author not found with id: " + authorDTO.getId());
                }
            } else {
                // If author ID is not provided, create a new author
                author = new Author();
                author.setName(authorDTO.getName());
                // Save the new author to avoid TransientObjectException
                author = authorRepository.save(author);
            }
            updatedAuthors.add(author);
        }

        // Set the updated authors for the book
        book.setAuthors(updatedAuthors);

        // Save and return the updated book
        return bookRepository.save(book);
    }


    @Transactional
    public void deleteBookAndAuthors(Long id) {
        // Retrieve the book entity to delete
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        // Remove the book from each author's book set to avoid Hibernate constraints
        for (Author author : book.getAuthors()) {
            author.getBooks().remove(book);
            authorRepository.save(author);
        }

        // Clear the authors set in the book entity
        book.getAuthors().clear();

        // Delete the book entity
        bookRepository.delete(book);

        // Optional: Delete authors with no associated books
        for (Author author : book.getAuthors()) {
            if (author.getBooks().isEmpty()) {
                authorRepository.delete(author);
            }
        }
    }

    @Override
    public Book getBookAuthorsById(long id) {
        return bookRepository.findById(id).get();
    }
}

