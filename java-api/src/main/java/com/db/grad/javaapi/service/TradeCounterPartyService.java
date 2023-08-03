package com.db.grad.javaapi.service;


import com.db.grad.javaapi.model.TradeCounterParty;
import com.db.grad.javaapi.repository.TradeCounterPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeCounterPartyService {
    private TradeCounterPartyRepository tr;

    @Autowired
    public TradeCounterPartyService(TradeCounterPartyRepository tr) {
        this.tr = tr;
    }
    public List<TradeCounterParty> getAllTradeCounterParties() {
        return tr.findAll();
    }
}
