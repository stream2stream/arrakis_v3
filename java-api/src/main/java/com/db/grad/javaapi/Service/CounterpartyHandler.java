package com.db.grad.javaapi.Service;


import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.repository.CounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CounterpartyHandler implements ICounterpartyService{
    private CounterpartyRepository counterpartyRepository;

    @Autowired
    public CounterpartyHandler(CounterpartyRepository counterpartyRepository) {
        this.counterpartyRepository = counterpartyRepository;
    }

    @Override
    public List<Counterparty> getAllCounterparties() {
        return counterpartyRepository.findAll();
    }

    @Override
    public Counterparty addCounterparty(Counterparty theCounterparty) {
        return counterpartyRepository.save(theCounterparty);
    }

    @Override
    public long getNoOfCounterparties() {
        return counterpartyRepository.count();
    }

    @Override
    public boolean removeCounterparty(long uniqueId) {
        boolean result = false;

        Optional<Counterparty> theCounterparty = counterpartyRepository.findById(uniqueId);
        if(theCounterparty.isPresent())
        {
            counterpartyRepository.delete(theCounterparty.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Counterparty getCounterpartyById(long uniqueId) {
        return counterpartyRepository.findById(uniqueId).get();
    }

    @Override
    public Counterparty getCounterpartyByName(String counterpartyName) {
        Counterparty counterpartyToFind = new Counterparty();
        counterpartyToFind.setName(counterpartyName);
        List<Counterparty> counterpartyList = counterpartyRepository.findByName(counterpartyToFind);
        Counterparty result = null;

        if( counterpartyList.size() == 1)
            result = counterpartyList.get(0);

        return result;
    }

    @Override
    public Counterparty updateCounterpartyDetails(Counterparty counterpartyToUpdate) {
        return counterpartyRepository.save(counterpartyToUpdate);
    }
}
