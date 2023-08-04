package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.service.TradesCounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class TradesCounterPartyController {

    private TradesCounterPartyService tradesCounterPartyService;

    @Autowired
    public TradesCounterPartyController(TradesCounterPartyService tradesCounterPartyService) {
        this.tradesCounterPartyService = tradesCounterPartyService;
    }

    @GetMapping(value = {"/bondHolderId/{id}"})
    public String getBondHolderNameById(@PathVariable(value = "id") int id){
        return tradesCounterPartyService.getBondHolderNameByID(id);
    }
}
