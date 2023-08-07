package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UsersHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    private UsersHandler userService;

    @Autowired
    public UserController(UsersHandler ds) {userService = ds;}

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {return userService.getAllUsers();
    }
}
