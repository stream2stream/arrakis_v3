package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.TradesCounterParty;
import com.db.grad.javaapi.repository.TradesCounterPartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class TradesCounterPartyServiceImpl implements TradesCounterPartyService {
    private final TradesCounterPartiesRepository tradesCounterPartiesRepository;

    @Autowired
    public TradesCounterPartyServiceImpl(TradesCounterPartiesRepository tradesCounterPartiesRepository) {
        this.tradesCounterPartiesRepository = tradesCounterPartiesRepository;
    }

    @Override
    public String getBondHolderNameByID(int id) {
        TradesCounterParty tradeCounterParty= tradesCounterPartiesRepository.findById(id).orElse(null);
        if (tradeCounterParty != null) {
            return tradeCounterParty.getBondHolderName();
        } else {
            return null;
        }
    }
}
