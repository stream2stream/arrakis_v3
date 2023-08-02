package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;

import java.util.Date;
import java.util.List;

public interface BondService {
    List<Bond> getAllBonds();

    List<Bond> getAllBondsForBusinessDaysBeforeAndAfter(Date date, int daysBefore, int daysAfter);
//    Bond getBondByDate(Date date);
//
//
//
//    boolean removeBond(String isin);
//
//    Bond getBondById(String isin);
//
//
//    Bond updateBond(Bond bond);
//
//    Bond addBond(Bond bond);
//
//    int getNoOfBonds();
    //TODO: Implement new methods here




}
