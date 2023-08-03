package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BondHolder;
import com.db.grad.javaapi.repository.BondHolderRepository;

import java.util.List;

public interface BondHolderService {
    public List<BondHolder> getAllBondHolders();
}
