package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TradeController {
    private TradeService ts;

    @Autowired TradeController(TradeService ts){
        this.ts = ts;
    }

    @GetMapping("/trade")
    public List<Trade> getAllTrades(){
        return ts.getAll();
    }

    @GetMapping("/trade/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable(value="id")int id)
            throws ResourceNotFoundException {
        Trade trades = ts.getById(id);
        return ResponseEntity.ok().body(trades);
    }

    @GetMapping("/trade/issuer/{issuer}")
    public ResponseEntity<List<Trade>> identifyIsinCusip(@PathVariable(value="issuer")String issuer)
        throws ResourceNotFoundException{
        List<Trade> trades = ts.getByName(issuer);
        return ResponseEntity.ok().body(trades);
    }


}
