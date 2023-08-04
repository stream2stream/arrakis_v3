package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.LoginDTO;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    private UserService usersService;

    @Autowired
    public UsersController(UserService us) {
        usersService = us;
    }

    @PostMapping("/check_login")
    public ResponseEntity<String> checkLoginDetails(@RequestBody LoginDTO loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        boolean valid = usersService.checkLoginDetails(username, password);
        if (valid) {
            return ResponseEntity.status(HttpStatus.OK).body("Login credential verification is successful.\n");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login credential verification failed.\n");
        }
    }
}
