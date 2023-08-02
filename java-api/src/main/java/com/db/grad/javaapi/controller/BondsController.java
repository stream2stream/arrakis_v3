package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Bonds;
import com.db.grad.javaapi.service.BondsHandler;
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
    private BondsHandler bondsService;

    @Autowired
    public BondsController(BondsHandler ds)
    {
        bondsService = ds;
    }

    @GetMapping("/dogs")
    public List <Bonds> getAllDogs() {
        return bondsService.getAllDogs();
    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity <Bonds> getBondsById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Bonds bonds = bondsService.getDogById(id);
        return ResponseEntity.ok().body(bonds);
    }

    @PostMapping("/dogs")
    public Bonds createDog(@Valid @RequestBody Bonds bonds) {
        return bondsService.addDog(bonds);
    }

    @PutMapping("/dogs/{id}")
    public ResponseEntity <Bonds> updateDog(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody Bonds bondsDetails) throws ResourceNotFoundException {

        final Bonds updatedDogs = bondsService.updateDogDetails(bondsDetails);
        return ResponseEntity.ok(updatedDogs);
    }

    @DeleteMapping("/dogs/{id}")
    public Map < String, Boolean > deleteDog(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
    	boolean removed = bondsService.removeDog(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
