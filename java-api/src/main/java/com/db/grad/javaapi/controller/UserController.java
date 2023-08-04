package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserHandler userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        int loginResponse = userService.checkEmailAndPassword(email, password);
        if(loginResponse == -1)
            return new ResponseEntity<>("Wrong credentials", HttpStatus.UNAUTHORIZED);
        else
            return new ResponseEntity<>("Worked", HttpStatus.OK);
    }
}
