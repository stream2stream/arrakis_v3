package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class BondService {

    @Autowired
    private BondRepository bondRepository;

    public List<Bond> getAllActiveBonds() {
        return bondRepository.findAll();
    }

    // TODO: check the dateformat in database and implement
//    public List<Bond> getBondsDueForMaturityInLastAndNext5Days() {
//        // Assuming "bondMaturityDate" is stored as a String in the format "YYYY-MM-DD"
//        LocalDate currentDate = LocalDate.now();
//        LocalDate fiveDaysFromNow = currentDate.plusDays(5);
//
//        return bondRepository.findByBondMaturityDateBetween(currentDate.toString(), fiveDaysFromNow.toString());
//    }

//    public List<Bond> getBondsDueForMaturityInLastAndNext5Days() {
//        // Assuming "bondMaturityDate" is stored as a String in the format "YYYY-MM-DD"
//        LocalDate currentDate = LocalDate.now();
//        LocalDate fiveDaysFromNow = currentDate.plusDays(5);
//
//        return bondRepository.findByBondMaturityDateBetween(currentDate.toString(), fiveDaysFromNow.toString());
//    }

}
