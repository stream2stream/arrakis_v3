package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.BooksUsersService;
import com.db.grad.javaapi.service.UsersHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BooksUsersController {

    @Autowired
    private BooksUsersService booksUserService;

    @GetMapping("/getBondsOfUser/{bondholder}")
    public List<String> getAllBooksUser(@PathVariable String bondholder) {return booksUserService.getAllBooksUserS(bondholder);
    }
}
