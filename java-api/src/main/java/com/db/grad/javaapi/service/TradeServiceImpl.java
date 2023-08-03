package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private final TradesRepository tradesRepository;

    public TradeServiceImpl(TradesRepository tradesRepository) {
        this.tradesRepository = tradesRepository;
    }

    @Override
    public List<Trade> getAllTradesByISIN(String ISIN) {
        List<Trade> tradesByISIN = new ArrayList<>();

        for (Trade trade : tradesRepository.findAll()) {
            if (trade.getIsin().equals(ISIN)) {
                tradesByISIN.add(trade);
            }
        }
        return tradesByISIN;
    }
}
