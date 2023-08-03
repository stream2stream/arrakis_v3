package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BondHolder;
import com.db.grad.javaapi.repository.BondHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BondHolderHandler implements BondHolderService {
    private BondHolderRepository itsBondHolderRepo;

    @Autowired
    public BondHolderHandler( BondHolderRepository bondHolderRepo )
    {
        itsBondHolderRepo = bondHolderRepo;
    }

    @Override
    public List<BondHolder> getAllBondHolders() {
        return itsBondHolderRepo.findAll();
    }
}
