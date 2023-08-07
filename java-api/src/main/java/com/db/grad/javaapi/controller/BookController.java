package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    private BookService bs;

    @Autowired
    public BookController(BookService bs){
        this.bs = bs;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bs.getAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value="id")int id)
            throws ResourceNotFoundException{
        Book books = bs.getById(id);
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/books/issuer/{issuer}")
    public ResponseEntity<List<Book>> getBookByIssuer(@PathVariable(value="issuer")String issuer)
            throws ResourceNotFoundException{
        List<Book> books = bs.getByName(issuer);
        return ResponseEntity.ok().body(books);
    }

}
