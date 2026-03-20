package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
@RestController
@RequestMapping("/books")

public class BookController {
    private final BookService service;
    public BookController(BookService service) {
        this.service = service;
    }
    @PostMapping
    public Book create (@RequestBody Book book) {
        return service.addBook(book);
    }
    @GetMapping
    public List<Book> getAll(){
        return service.getBooks();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        service.deleteBook(id);
        return ResponseEntity.ok().body(Collections.singletonMap("message", "Book deleted Successfully"));
    }
    @PatchMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){
        return service.updateBook(id, book);
    }
}
