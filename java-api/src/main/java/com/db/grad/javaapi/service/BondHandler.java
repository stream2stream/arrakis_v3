package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BondHandler implements BondService {
    private BondRepository itsBondRepo;

    @Autowired
    public BondHandler( BondRepository bondRepo )
    {
        itsBondRepo = bondRepo;
    }

    @Override
    public List<Bond> getAllBonds() {
        return itsBondRepo.findAll();
    }
}
