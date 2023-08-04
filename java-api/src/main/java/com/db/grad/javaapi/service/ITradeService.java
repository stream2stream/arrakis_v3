package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trades;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITradeService {
    List<Trades> getAllTrades();

    Trades getTradesById(Long id);

    Trades updateTradeDetails(Trades tradeToUpdate);

    Trades addTrade(Trades trade);

    boolean removeTrade(long uniqueId);
}
