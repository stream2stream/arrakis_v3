package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BondsController {

    @Autowired
    BondsService bondsService;

    @GetMapping("/bonds")
    public List<Bond> getAllBonds() {
        return bondsService.getBonds();
    }
    @GetMapping("/bonds/maturity")
    public List<Bond> getBondsByMaturity(){
        return bondsService.getBondMaturity();
    }
}
