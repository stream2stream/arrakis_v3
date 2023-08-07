package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService implements IService<Trade>{

    private TradeRepository tradeRepo;

    @Autowired
    public TradeService (TradeRepository tr){
        tradeRepo = tr;
    }

    @Override
    public List<Trade> getAll() {
        return tradeRepo.findAll();
    }

    @Override
    public int getNoOf() {
        return (int) tradeRepo.count();
    }

    @Override
    public Trade getById(Integer uniqueId) {
        return tradeRepo.findById(uniqueId).get();
    }

    @Override
    public List<Trade> getByName(String issuer) {
        List<Trade> result = null;
        List<Trade> trades = tradeRepo.identifyIsinCusip(issuer);
        if (trades.size()>=1){
            result = trades;
        }
        return result;

    }
}
