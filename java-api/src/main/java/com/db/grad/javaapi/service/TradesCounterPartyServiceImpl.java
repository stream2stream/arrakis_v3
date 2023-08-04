package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.TradesCounterParty;
import com.db.grad.javaapi.repository.TradesCounterPartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public  class TradesCounterPartyServiceImpl implements TradesCounterPartyService {
    private final TradesCounterPartiesRepository tradesCounterPartiesRepository;

    @Autowired
    public TradesCounterPartyServiceImpl(TradesCounterPartiesRepository tradesCounterPartiesRepository) {
        this.tradesCounterPartiesRepository = tradesCounterPartiesRepository;
    }

    @Override
    public String getBondHolderNameByID(int id) {
        String bondHolderName = null;

        for (TradesCounterParty tradesCounterParties : tradesCounterPartiesRepository.findAll()) {
            if (tradesCounterParties.getId() == id) {
                bondHolderName = tradesCounterParties.getBondHolderName();
            }
        }
        return bondHolderName;
    }
}
