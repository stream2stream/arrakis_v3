package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.Trade;

import java.util.List;

public interface ITradeService {
    List<Trade> getAllTrades();

    Trade addTrade(Trade theTrade);

    long getNoOfTrades();

    boolean removeTrade(long uniqueId);

    Trade getTradeById(long uniqueId);

    Trade getTradeByBookID(long BookID);

    Trade updateTradeDetails(Trade TradeToUpdate);

}