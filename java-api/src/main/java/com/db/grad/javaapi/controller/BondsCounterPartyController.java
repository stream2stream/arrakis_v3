package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondsCounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class BondsCounterPartyController {
    private BondsCounterPartyService bondsCounterPartyService;

    @Autowired
    public BondsCounterPartyController(BondsCounterPartyService bondsCounterPartyService) {
        this.bondsCounterPartyService = bondsCounterPartyService;
    }

    @GetMapping(value = {"/issuer/{id}"})
    public String getIssuerNameByID(@PathVariable(value = "id") int id){
        return bondsCounterPartyService.getIssuerNameByID(id);
    }
}
