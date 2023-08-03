package com.db.grad.javaapi.service;


import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondService {
    private BondRepository br;

    @Autowired
    public BondService(BondRepository itsBondRepo) {
        this.br = itsBondRepo;
    }


    public List<Bond> getAllBonds() {
        return br.findAll();
    }


    public List<Bond> findBondsByBookId(int bookId) {
        return br.findBondsByBookId(bookId);
    }
}
