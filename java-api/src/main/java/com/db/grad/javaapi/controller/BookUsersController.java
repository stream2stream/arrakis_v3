package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.BookUsers;
import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.service.BookUsersHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookUsersController {
    private BookUsersHandler BookUsersService;

    @Autowired
    public BookUsersController(BookUsersHandler bs)
    {
        BookUsersService = bs;
    }

    @GetMapping("/bookUsers")
    public List <String> getAllBookUsers(String bondholder) {return BookUsersService.getAllBookUsers(bondholder);}

    @GetMapping("/bookUsers/{id}")
    public ResponseEntity <Books> getEmployeeById(@PathVariable(value = "id") String id)
    throws ResourceNotFoundException {
        Books books = BookUsersService.getBookUsersById(id);
        return ResponseEntity.ok().body(books);
    }

//    @PostMapping("/bookUsers")
//    public BookUsers createBook(@RequestBody BookUsers bookUser) {
//        return BookUsersService.addBookUsers(bookUser);
//    }

//    @PutMapping("/bookUsers/{id}")
//    public ResponseEntity < BookUsers > updateBook(@PathVariable(value = "id") Long id,
//        @RequestBody BookUsers bookDetails) throws ResourceNotFoundException {
//
//        final BookUsers updatedBooks = BookUsersService.updateBookUsersDetails(bookDetails);
//        return ResponseEntity.ok(updatedBooks);
//    }

//    @DeleteMapping("/bookUsers/{id}")
//    public Map < String, Boolean > deleteBook(@PathVariable(value = "id") Integer id)
//    throws ResourceNotFoundException {
//    	boolean removed = BookUsersService.removeBookUser(id);
//
//        Map < String, Boolean > response = new HashMap <>();
//        if( removed )
//            response.put("deleted", Boolean.TRUE);
//        else
//            response.put("deleted", Boolean.FALSE);
//
//        return response;
//    }
}
