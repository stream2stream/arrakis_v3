package com.db.grad.javaapi.controller;




import com.db.grad.javaapi.Service.CounterpartyHandler;
import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Counterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
public class CounterpartyController {

    CounterpartyHandler counterpartyHandler;

    @Autowired
    public CounterpartyController(CounterpartyHandler counterpartyHandler) {
        this.counterpartyHandler = counterpartyHandler;
    }

    @GetMapping("/counterparties")
    public List<Counterparty> getAllCounterparties() {
        return counterpartyHandler.getAllCounterparties();
    }

    @GetMapping("/counterparties/{id}")
    public ResponseEntity < Counterparty > getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Counterparty counterparties = counterpartyHandler.getCounterpartyById(id);
        return ResponseEntity.ok().body(counterparties);
    }

    @PostMapping("/counterparties")
    public Counterparty createCounterparty(@Valid @RequestBody Counterparty counterparty) {
        return counterpartyHandler.addCounterparty(counterparty);
    }

    @PutMapping("/counterparties/{id}")
    public ResponseEntity < Counterparty > updateCounterparty(@PathVariable(value = "id") Long id,
                                                @Valid @RequestBody Counterparty counterpartyDetails) throws ResourceNotFoundException {

        final Counterparty updatedCounterparties = counterpartyHandler.updateCounterpartyDetails(counterpartyDetails);
        return ResponseEntity.ok(updatedCounterparties);
    }

    @DeleteMapping("/counterparties/{id}")
    public Map< String, Boolean > deleteCounterparty(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = counterpartyHandler.removeCounterparty(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
