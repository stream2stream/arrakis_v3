package com.db.grad.javaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.service.TradesService;
import com.db.grad.javaapi.model.Trade;

@RestController
@RequestMapping("/api/v1")
public class TradesController {

    @Autowired
    private TradesService tradesService;

    @GetMapping("/trades")
    public List<Trade> getAllTrades() {
        return tradesService.getAllTrades();
    }

    @GetMapping("/trades/user/{username}")
    public List<Trade> getTradesByUsername(@PathVariable String username) {
        return tradesService.getAllTradesByUsername(username);
    }

    @GetMapping("/trades/{id}")
    public Trade getTradeById(@PathVariable Integer id) {
        return tradesService.getTradeById(id);
    }

}
