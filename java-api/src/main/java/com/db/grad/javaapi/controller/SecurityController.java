package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.BondTransactionDTO;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/bonds")
    public List<Security> getActiveBonds() {
        return securityService.getBonds();
    }

    @GetMapping("/bonds_transactions")
    public ArrayList<BondTransactionDTO> getActiveBondsTransactions() {
        return securityService.getActiveBondsTransactions();
    }

}
