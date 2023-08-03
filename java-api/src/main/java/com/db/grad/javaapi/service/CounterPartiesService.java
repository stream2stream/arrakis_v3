package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.repository.CounterPartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CounterPartiesService {

    @Autowired
    private CounterPartiesRepository counterPartiesRepository;

    public List<CounterParty> getAllCounterParties() {
        return counterPartiesRepository.findAll();
    }

    public CounterParty getCounterPartyById(int id) {
        Optional<CounterParty> counterParty = counterPartiesRepository.findById(id);
        return counterParty.orElse(null);
    }
}
