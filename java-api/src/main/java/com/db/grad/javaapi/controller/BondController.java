package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//package com.db.grad.javaapi.controller;
//
//import com.db.grad.javaapi.exception.ResourceNotFoundException;
//import com.db.grad.javaapi.model.Dog;
//import com.db.grad.javaapi.service.DogHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BondController {
    private AppService s;

    @Autowired
    public BondController(AppService s)
    {
        this.s = s;
    }

    @GetMapping("/getAllBonds")
    public List<Bond> getAllBonds(){
        return s.getAllBonds();
    }

    @GetMapping("/getAllTrades")
    public List<Trade> getAllTrade(){
        return s.getAllTrades();
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return s.getAllBooks();
    }


    @GetMapping("/getBondsByBookId")
    public List<Bond> getBondsByBookId(@RequestParam int bookId) {
        return s.findBondsByBookId(bookId);
    }
}
