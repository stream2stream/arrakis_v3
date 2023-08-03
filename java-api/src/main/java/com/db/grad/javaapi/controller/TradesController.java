package com.db.grad.javaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.service.TradesService;
import com.db.grad.javaapi.model.Trade;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TradesController {

    private TradesService tradesService;

    @GetMapping("/trades")
    public List<Trade> getAllTrades() {
        return tradesService.getAllTrades();
    }

    @GetMapping("/trades/{id}")
    public Trade getTradeById(@PathVariable(value = "id") Integer id) {
        return tradesService.getTradeById(id);
    }

}
