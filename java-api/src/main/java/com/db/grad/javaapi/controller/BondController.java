package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonds")
public class BondController {

    @Autowired
    private BondRepository bondRepository;

    @GetMapping
    public List<Bond> getAllBonds() {
        return bondRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bond getBondById(@PathVariable Long id) {
        return bondRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Bond createBond(@RequestBody Bond bond) {
        return bondRepository.save(bond);
    }

    @PutMapping("/{id}")
    public Bond updateBond(@PathVariable Long id, @RequestBody Bond updatedBond) {
        Bond bond = bondRepository.findById(id).orElse(null);
        if (bond != null) {
            // Update the bond properties from the updatedBond object
            bond.setBondCurrencyCusip(updatedBond.getBondCurrencyCusip());
            bond.setFaceValue(updatedBond.getFaceValue());
            // ... Set other properties

            return bondRepository.save(bond);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBond(@PathVariable Long id) {
        bondRepository.deleteById(id);
    }
}
