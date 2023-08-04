package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SecurityController {
    @Autowired
    private SecurityService securityService;

    @PostMapping("/bonds/user")
    public ResponseEntity<List<Security>> getAllSecuritiesForUserBooks(@RequestParam("userMail") String userMail) {
        List<Security> securities = securityService.getAllSecuritiesForUserBooks(userMail);
        return ResponseEntity.ok(securities);
    }
}
