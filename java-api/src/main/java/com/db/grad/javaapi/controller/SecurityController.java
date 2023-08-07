package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecurityController {

    private SecurityService ss;

    @Autowired
    SecurityController (SecurityService ss){
        this.ss = ss;
    }

    @GetMapping("/security")
    public List<Security> getAllSecurities(){
        return ss.getAll();
    }

    @GetMapping("/security/{id}")
    public ResponseEntity<Security> getSecurityById(@PathVariable(value="id")int id)
            throws ResourceNotFoundException {
        Security securities = ss.getById(id);
        return ResponseEntity.ok().body(securities);
    }

    @GetMapping("/security/issuer/{issuer}")
    public ResponseEntity<List<Security>> identifyIsinCusip(@PathVariable(value="issuer")String issuer)
            throws ResourceNotFoundException{
        List<Security> securities = ss.getByName(issuer);
        return ResponseEntity.ok().body(securities);
    }

    @GetMapping("/security/cusip/{cusip}")
    public ResponseEntity<List<Security>> idntifyissuer_Cusip(@PathVariable(value="cusip")String cusip)
            throws ResourceNotFoundException{
        List<Security> securities = ss.getByCusip(cusip);
        return ResponseEntity.ok().body(securities);
    }
}
