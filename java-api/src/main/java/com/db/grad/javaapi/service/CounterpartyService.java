package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.repository.CounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterpartyService implements IService<Counterparty> {

    private CounterpartyRepository counterpartyRepo;

    @Autowired
    public CounterpartyService(CounterpartyRepository cr){
        counterpartyRepo = cr;
    }

    @Override
    public List<Counterparty> getAll() {
        return counterpartyRepo.findAll();
    }

    @Override
    public int getNoOf() {
        return (int) counterpartyRepo.count();
    }

    @Override
    public Counterparty getById(Integer uniqueId) {
        return counterpartyRepo.findById(uniqueId).get();
    }

    @Override
    public List<Counterparty> getByName(String issuer) {
        List<Counterparty> counterparties = counterpartyRepo.findClientName(issuer);
        List<Counterparty> result = null;
        if (counterparties.size() >= 1)
            result = counterparties;
        return result;
    }

}
