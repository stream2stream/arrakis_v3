package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;

import java.util.List;

public interface ITradesService {
    public List<Trade> getAllTrades();
    public Trade addTrade(Trade theTrade);
    public boolean removeTrade(long id);
    public Trade getTradeByID(long id);
    public Trade updateTradeDetails(Trade TradeToUpdate);
}
