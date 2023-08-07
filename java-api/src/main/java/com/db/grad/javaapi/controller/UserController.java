package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService us;

    @Autowired
    public UserController (UserService us) {
        this.us = us;
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return us.getAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value="id")int id)
            throws ResourceNotFoundException {
        User users = us.getById(id);
        return ResponseEntity.ok().body(users);
    }
}
