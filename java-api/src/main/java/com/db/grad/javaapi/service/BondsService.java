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

    private final static int SECONDS_IN_DAY = 86400;

    @Autowired
    private BondsRepository bondsRepository;

    public List<Bond> getAllBonds() {

        return bondsRepository.findAll();
    }
    public List<Bond> getBondsByMaturity() {

        List<Bond> bonds = bondsRepository.findAll(), result = new ArrayList<Bond>();

        long curr = (new Date().getTime()/100000), temp;

        for(Bond bond : bonds) {

            try {
                temp = new SimpleDateFormat("yyyy-mm-dd").parse(bond.getBondMaturity()).getTime()/100000;

                if(Math.abs(curr-temp)/SECONDS_IN_DAY-1 <= 5) {
                    result.add(bond);
                }
            }
            catch(ParseException e) {
                System.out.println(e);
            }

        }

        return result;
    }
}
