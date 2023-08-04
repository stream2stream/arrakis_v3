package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.service.BooksHandler;
import com.db.grad.javaapi.service.BooksUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksHandler booksService;

    @GetMapping("/getAllBooks")
    public List<Books> getAllBooks() {return booksService.getAllBooks();
    }
    @GetMapping("/getBondsPlusMinus5Days/{date}")
    public List<String> getBondsPlusMinus5Days(@PathVariable String date) {return booksService.getBondsPlusMinus(date);
    }
    @GetMapping("/getMaturity/")
    public List<String> getMaturityDate() {return booksService.getMatDate();
    }

}
