package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/login")
    public int login(@RequestParam("u") String username, @RequestParam("p") String password) {

        return usersService.login(username, password);
    }
}
