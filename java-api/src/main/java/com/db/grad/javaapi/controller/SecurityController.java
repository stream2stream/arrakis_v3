package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityHandler;
import org.springdoc.core.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class SecurityController {
    private SecurityHandler SecurityHandler;
    @Autowired
    public SecurityController(SecurityHandler sS){
        SecurityHandler = sS;
    }
    @GetMapping("/securities")
    public List<Security> getAllSecurities() {
        return SecurityHandler.getAllSecurities();
    }
}
