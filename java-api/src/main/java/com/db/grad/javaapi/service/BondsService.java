package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
@Service
public class BondsService {
    private final static int SECONDS_IN_DAY = 86400;

    @Autowired
    private BondsRepository bondsRepository;

    public List<Bond> getBonds() {

        return bondsRepository.findAll();
    }
    public List<Bond> getBondMaturity(){

        List<Bond> bonds = bondsRepository.findAll();

        LocalDate today = LocalDate.now();

        for(Bond bond :  bonds){
            Period period = Period.between(today, LocalDate.parse(bond.getBondMaturity()))
            if()
                bonds.remove(bond);
        }

        return bonds;
    }
}
