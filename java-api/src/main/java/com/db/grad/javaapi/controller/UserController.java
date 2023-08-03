package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private UserHandler userHandler;
    @Autowired
    public UserController(UserHandler uT){
        userHandler = uT;
    }
    @GetMapping("/users/{id}")
    public User getTradeById(@PathVariable(value = "id") long id){
        return userHandler.getUserByID(id);
    }
    @GetMapping("/users/{username}")
    public User getTradeBySecurityID(@PathVariable(value = "id") String username){
        return UserHandler.getUserByUsername(username);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userHandler.getAllUsers();
    }
}