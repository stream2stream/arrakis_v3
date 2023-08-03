package com.db.grad.javaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecuritiesService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class SecuritiesController {

    private SecuritiesService securitesService;

    public SecuritiesController(SecuritiesService securitiesService) {
        this.securitesService = securitiesService;
    }    

    @GetMapping("/securities")
    public List<Security> getAllSecurities() {
        return securitesService.getAllSecurities();
    }

    @GetMapping("/securities/{id}")
    public Security getSecurityById(Integer id) {
        return securitesService.getSecurityById(id);
    }

}
