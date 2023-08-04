package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BondsCounterParty;
import com.db.grad.javaapi.model.TradesCounterParty;
import com.db.grad.javaapi.repository.BondsCounterPartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BondsCounterPartyServiceImpl implements BondsCounterPartyService {

    private final BondsCounterPartiesRepository bondsCounterPartiesRepository;

    @Autowired
    public BondsCounterPartyServiceImpl(BondsCounterPartiesRepository bondsCounterPartiesRepository) {
        this.bondsCounterPartiesRepository = bondsCounterPartiesRepository;
    }

    @Override
    public String getIssuerNameByID(int id) {
        String issuerName = null;

        for (BondsCounterParty bondsCounterParty : bondsCounterPartiesRepository.findAll()) {
            if (bondsCounterParty.getId() == id) {
                issuerName = bondsCounterParty.getIssuerName();
            }
        }
        return issuerName;
    }

}
