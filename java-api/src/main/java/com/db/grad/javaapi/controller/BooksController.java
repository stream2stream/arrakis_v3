package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {
    @Autowired
    BooksService booksService = new BooksService();
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable String id) {
        return booksService.getBookById(Integer.parseInt(id));
    }
}
