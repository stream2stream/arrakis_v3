package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondsService {

    @Autowired
    private BondsRepository bondsRepository;

    public List<Bond> getBonds() {

        return bondsRepository.findAll();
    }
}
