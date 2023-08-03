package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.BookHandler;
import com.db.grad.javaapi.service.SecurityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class SecurityController {

    private SecurityHandler securityService;

    @Autowired
    public SecurityController(SecurityHandler ds)
    {
        securityService = ds;
    }

    @GetMapping("/security")
    public List<Security> getAllSecurity() {
        return securityService.getAllSecurity();
    }

}
