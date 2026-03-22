package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookService {
    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository repository;
    public BookService(BookRepository repository) {
        this.repository = repository;

    }

    public Book addBook(Book book) {
        return repository.save(book);
    }
    public Book updateBook( Book book) {
        return repository.save(book);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }
    public void deleteBook(int id) {
        repository.deleteById(id);
        log.info("Book deleted successfully with id: {}", id);
    }
    public Book updateBook(int id, Book book){
        Book existingBook = repository.findById(id).orElseThrow();
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setDescription(book.getDescription());
        return repository.save(existingBook);
    }
}
