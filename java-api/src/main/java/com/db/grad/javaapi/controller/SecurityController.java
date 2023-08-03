package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.BondDTO;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    @GetMapping("/bonds")
    public List<BondDTO> getActiveBonds() {
        return securityService.getBonds();
    }

}
