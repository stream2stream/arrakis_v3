package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BondController {
    private BookService bs;
    private CounterpartyService cs;
    private SecurityService ss;
    private TradeService ts;
    private UserService us;


//    @Autowired
//    public BondController(BookService bs, CounterpartyService cs, SecurityService ss, TradeService ts, UserService us){
//        this.bs = bs;
//        this.cs = cs;
//        this.ss = ss;
//        this.ts = ts;
//        this.us = us;
//    }




    //    @GetMapping("/dogs")
//    public List <Dog> getAllDogs() {
//        return dogsService.getAllDogs();
//    }



}
