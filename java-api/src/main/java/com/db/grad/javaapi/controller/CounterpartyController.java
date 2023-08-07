package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.service.CounterpartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
public class CounterpartyController {

    private CounterpartyService cs;

    @Autowired
    public CounterpartyController (CounterpartyService cs){
        this.cs = cs;
    }

    @GetMapping("/counterparty")
    public List<Counterparty> getAllCounterparties(){
        return cs.getAll();
    }

    @GetMapping("/counterparty/{id}")
    public ResponseEntity<Counterparty> getCounterpartyById(@PathVariable(value="id")int id)
        throws ResourceNotFoundException{
        Counterparty counterparties = cs.getById(id);
        return ResponseEntity.ok().body(counterparties);
    }

    @GetMapping("/counterparty/issuer/{issuer}")
    public ResponseEntity<List<Counterparty>> getCounterpartyByIssuer(@PathVariable(value="issuer")String issuer)
            throws ResourceNotFoundException{
        List<Counterparty> counterparties = cs.getByName(issuer);
        return ResponseEntity.ok().body(counterparties);
    }

}
