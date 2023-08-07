package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/securities")
@CrossOrigin(origins = "http://localhost:3000")
public class SecurityController {

    @Autowired
    private SecurityHandler securityService;

    @GetMapping()
    public ResponseEntity<List<Security>> getAllSecurities() {
        return new ResponseEntity<>(securityService.getAllSecurities(), HttpStatus.OK);
    }

    @PostMapping("/maturity")
    public ResponseEntity<List<Security>> getSecuritiesByMaturityDate(@RequestBody Date date){
        List<Security> datesList = securityService.getSecuritiesByMaturityDate(date);
        return new ResponseEntity<>(datesList, HttpStatus.OK);
    }
}
