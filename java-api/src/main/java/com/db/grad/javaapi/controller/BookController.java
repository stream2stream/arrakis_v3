package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BookHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    private BookHandler BookHandler;
    @Autowired
    public BookController(BookHandler sT){
        BookHandler = sT;
    }
    @GetMapping("/Book/{id}")
    public Book getBookById(@PathVariable(value = "id") long id){
        return BookHandler.getBookByID(id);
    }
    @GetMapping("/Book/security/{id}")
    public Book getBookBySecurityID(@PathVariable(value = "id") long id){
        return BookHandler.getBookBySecurityID(id);
    }
    @GetMapping("/Book")
    public List<Book> getAllBooks() {
        return BookHandler.getAllBooks();
    }
}