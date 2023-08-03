package com.db.grad.javaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradesRepository;
import org.springframework.stereotype.Service;

@Service
public class TradesService {

    @Autowired
    private TradesRepository repo;

    public List<Trade> getAllTrades() {
        return repo.findAll();
    }

    public Trade getTradeById( Integer id ) {

        return repo.findById(id).get();
    }

}
