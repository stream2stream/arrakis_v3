package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BondsCounterParty;
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
        BondsCounterParty bondCounterParty = bondsCounterPartiesRepository.findById(id).orElse(null);
        if (bondCounterParty != null) {
            return bondCounterParty.getIssuerName();
        } else {
            return null;
        }
    }

}
