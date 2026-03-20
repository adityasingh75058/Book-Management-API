package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
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
        if(!repository.existsById(id)) {
            throw new RuntimeException("Book not found with id " + id);
        }
        repository.deleteById(id);
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
