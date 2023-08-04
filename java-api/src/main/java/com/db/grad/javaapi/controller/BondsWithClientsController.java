package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.BondWithClient;
import com.db.grad.javaapi.service.BondsWithClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BondsWithClientsController {
    private BondsWithClientsService bondsWithClientsService;

    @Autowired
    public BondsWithClientsController(BondsWithClientsService bwc) {
        bondsWithClientsService = bwc;
    }

    @GetMapping("/bondsWithClients")
    public List<BondWithClient> getBondsWithClients(){
        return bondsWithClientsService.getAllBondsWithClients();
    }
}
