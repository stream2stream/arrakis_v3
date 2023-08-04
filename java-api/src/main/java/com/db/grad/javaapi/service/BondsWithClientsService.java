package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BondWithClient;
import com.db.grad.javaapi.repository.BondsWithClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondsWithClientsService {

    @Autowired
    private BondsWithClientsRepository bondsWithClientsRepository;

    public List<BondWithClient> getAllBondsWithClients() {
        return bondsWithClientsRepository.findAll();
    }
}
