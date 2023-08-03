package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/securities")
public class SecurityController {
    @Autowired
    private SecurityService securityService;

    @GetMapping("/user/{userId}/securities")
    public ResponseEntity<List<Security>> getAllSecuritiesForUserBooks(@PathVariable String userId) {
        List<Security> securities = securityService.getAllSecuritiesForUserBooks(userId);
        return ResponseEntity.ok(securities);
    }
}
