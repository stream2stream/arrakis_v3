package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TradeController {
    private TradeHandler TradeService;

    @Autowired
    public TradeController(TradeHandler ds)
    {
        TradeService = ds;
    }


    @GetMapping("/Trades/{id}")
    public ResponseEntity < List<Trade> > getTradesByBookId(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        List<Trade> trades = TradeService.getTradesByBookId(id);
        return ResponseEntity.ok().body(trades);
    }

    @PostMapping("/Trades")
    public Trade createTrade(@Valid @RequestBody Trade trade) {
        return TradeService.addTrade(trade);
    }



}
