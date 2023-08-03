package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;

import java.util.List;

public interface ITradesService {
    public List<Trade> getAllSTrades();
    public Trade addTrade(Trade theTrade);
    public boolean removeTrade(long id);
    public Trade getTradeByID(long id);
    public Trade getSecurityBybookID(String bookID);
    public Trade updateSecurityDetails(Trade TradeToUpdate);
}
