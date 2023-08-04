package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/securities")
@CrossOrigin(origins = "http://localhost:3001")
public class SecurityController {

    @Autowired
    private SecurityHandler securityService;

    @GetMapping()
    public ResponseEntity<List<Security>> getAllSecurities() {
        return new ResponseEntity<>(securityService.getAllSecurities(), HttpStatus.OK);
    }
}
