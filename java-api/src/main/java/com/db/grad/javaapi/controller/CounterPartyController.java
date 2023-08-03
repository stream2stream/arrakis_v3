package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.CounterPartyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CounterPartyController {
    private CounterPartyHandler counterPartyHandler;
    @Autowired
    public CounterPartyController(CounterPartyHandler cS)
    {
        counterPartyHandler = cS;
    }
    @GetMapping("/counterParty/{id}")
    public CounterParty getCounterPartyByID(@PathVariable(value="id")long id) {
        return counterPartyHandler.getCounterPartyByID(id);
    }

}
