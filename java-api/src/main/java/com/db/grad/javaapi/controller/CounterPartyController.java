package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.BookHandler;
import com.db.grad.javaapi.service.CounterPartyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CounterPartyController {

    private CounterPartyHandler counterPartyService;

    @Autowired
    public CounterPartyController(CounterPartyHandler ds)
    {
        counterPartyService = ds;
    }

    @GetMapping("/book")
    public List<CounterParty> getAllCounterParty() {
        return counterPartyService.getAllCounterParty();
    }

}
