package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.utils.Triple;
import com.google.cloud.Tuple;

import java.util.List;
import java.util.Map;

public interface TradeService {
    List<Trade> getAllTradesByISIN(String ISIN);

    Triple<String, Integer, Double> getStatsByBondHolderID(int id);
}
