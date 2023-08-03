package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;

import java.util.List;

public interface BondService {
    public List<Bond> getAllBonds();
}
