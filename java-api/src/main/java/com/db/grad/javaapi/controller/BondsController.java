package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BondsController {
    private BondHandler bondsService;

    @Autowired
    public BondsController(BondHandler ds)
    {
        bondsService = ds;
    }

    @GetMapping("/bonds")
    public List <Bond> getAllBonds() {
        return bondsService.getAllBonds();
    }

    @GetMapping("/bonds/{id}")
    public ResponseEntity <Bond> getBondsById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Bond bond = bondsService.getBondsById(id);
        return ResponseEntity.ok().body(bond);
    }

    @PostMapping("/bonds")
    public Bond createBond(@Valid @RequestBody Bond bond) {
        return bondsService.addBond(bond);
    }

    @PutMapping("/bonds/{id}")
    public ResponseEntity <Bond> updateBonds(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Bond bondDetails) throws ResourceNotFoundException {

        final Bond updatedBonds = bondsService.updateBondsDetails(bondDetails);
        return ResponseEntity.ok(updatedBonds);
    }

    @DeleteMapping("/bonds/{id}")
    public Map < String, Boolean > deleteBond(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
    	boolean removed = bondsService.removeBond(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
