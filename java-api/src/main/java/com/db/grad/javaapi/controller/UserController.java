package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.service.TradeHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
    private UserHandler userService;

    @Autowired
    public UserController(UserHandler ds)
    {
        userService = ds;
    }

//    @GetMapping("User/{name}")
//    public User findUser(String name){
//        return userService.getBookId(name);
//    }

    @GetMapping("User")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("User/getId/{name}")
    public long getUserId(@PathVariable(value = "name") String name){
        return userService.getBookId(name);
    }

}
