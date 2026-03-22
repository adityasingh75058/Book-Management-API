package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
@RestController
@RequestMapping("/books")

public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
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
    public ResponseEntity<Map<String, String>> delete(@PathVariable int id){
        log.info("DELETE API called with id: {}", id);
        service.deleteBook(id);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Book deleted successfully");
        return ResponseEntity.ok(response);
    }
    @PatchMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){
        return service.updateBook(id, book);
    }
}
