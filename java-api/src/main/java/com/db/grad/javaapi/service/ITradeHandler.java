package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Trade;

import java.util.List;
import java.util.Optional;

public interface ITradeHandler
{
    public List<Trade> getAllTrades();

    public Trade addTrade(Trade newTrade);

    public long getNoOfTrades();

//    public List<Trade> findTradeByBookId(long id);
    public List<Trade> getTradesByBookId(long id);
//
//    public Trade getTradeByBookId(long id);
    // public boolean removeTrade(long Trade);

    // public Trade getTradeById(long Trade);
}
