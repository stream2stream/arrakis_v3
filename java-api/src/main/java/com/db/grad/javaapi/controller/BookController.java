package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.service.BooksHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    private BooksHandler BookService;

    @Autowired
    public BookController(BooksHandler bs)
    {
        BookService = bs;
    }

    /*
    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return BookService.getAllBooks();
    }
//
    @GetMapping("/books/{id}")
    public ResponseEntity <Books> getEmployeeById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Books books = BookService.getBookById(id);
        return ResponseEntity.ok().body(books);
    }
//
    @PostMapping("/books")
    public Books createBook(@RequestBody Books book) {
        return BookService.addBook(book);
    }

//doesnt work when bondmaturitydate is a String
    @PutMapping("/books/{id}")
    public ResponseEntity <Books> updateBook(@PathVariable(value = "id") Long id,
        @RequestBody Books bookDetails) throws ResourceNotFoundException {

        final Books updatedBooks = BookService.updateBookDetails(bookDetails);
        return ResponseEntity.ok(updatedBooks);
    }
//
    @DeleteMapping("/books/{id}")
    public Map < String, Boolean > deleteBook(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
    	boolean removed = BookService.removeBook(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
    */
}
