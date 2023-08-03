package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;

import java.util.List;

public interface IBondsSrvice
{
    public List<Bond> getAllBonds();

    public Bond addBond(Bond theBond);

    public long getNoOfBonds();

    public boolean removeBond(long uniqueId);

    public Bond getBondsById(long uniqueId);

    public Bond getBondsByISIN(String bondISIN );

    public Bond updateBondsDetails(Bond bondToUpdate);
}
