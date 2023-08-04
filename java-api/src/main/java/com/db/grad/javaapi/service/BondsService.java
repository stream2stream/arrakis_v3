package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
@Service
public class BondsService {

    private final static int MS_IN_DAY = 86400000;

    private BondsRepository bondsRepository;

    @Autowired
    public BondsService(BondsRepository bondsRepository) {
        this.bondsRepository = bondsRepository;
    }

    public List<Bond> getAllBonds() {

        return bondsRepository.findAll();
    }
    public List<Bond> getBondsByMaturity() {

        return bondsRepository.findByMaturity();
    }

    public List<Bond> getBondsWithClients() {
        return bondsRepository.findBondsWithCounterparty();
    }

    public Bond add(Bond bond) {

        return bondsRepository.save(bond);
    }
}
