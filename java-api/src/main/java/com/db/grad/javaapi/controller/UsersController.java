package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.service.UserService;
import com.google.api.client.json.webtoken.JsonWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = {"/users/signin"})
    public String signIn(@RequestBody String email, @RequestBody String password){

        return userService.signIn(email, password);
    }
/*
    Add UserController - login endpoint - post request - Response JSONWebToken
*/
}
