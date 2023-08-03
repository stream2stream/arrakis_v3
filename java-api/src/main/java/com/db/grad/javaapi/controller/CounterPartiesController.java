package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.CounterPartiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CounterPartiesController {

    @Autowired
    private CounterPartiesService counterPartiesService;

    @GetMapping("/counterparties")
    public List<CounterParty> getAllCounterParties() {
        return counterPartiesService.getAllCounterParties();
    }
    @GetMapping("/counterparties/{id}")
    public CounterParty getCounterPartyById(@PathVariable Integer id) {
        return counterPartiesService.getCounterPartyById(id);
    }
}
