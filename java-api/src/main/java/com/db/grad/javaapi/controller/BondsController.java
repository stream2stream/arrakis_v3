package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
import com.db.grad.javaapi.service.BondServiceImpl;
import com.db.grad.javaapi.service.model.MaturingBondType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class BondsController {
    private BondService bondService;

    @Autowired
    public BondsController(BondService bondService) {
        this.bondService = bondService;
    }

    @GetMapping("/bonds")
    public List<Bond> getAllBonds(){
        return bondService.getAllBonds();
    }

    @GetMapping(value = {"/bonds/dates/{date}/{daysBefore}/{daysAfter}"})
    public Map<String, MaturingBondType> getNoOfBondsForBusinessDaysBeforeAndAfterOfType(@PathVariable(value = "date") String date,
                                                                                         @PathVariable(value = "daysBefore") int daysBefore,
                                                                                         @PathVariable(value = "daysAfter") int daysAfter) throws ParseException {

        return bondService.getAllBondsForBusinessDaysBeforeAndAfter(date, daysBefore, daysAfter);
    }


//    @PostMapping("/dogs")
//    public Dog createDog(@Valid @RequestBody Dog dog) {
//        return dogsService.addDog(dog);
//    }
//
//    @PutMapping("/dogs/{id}")
//    public ResponseEntity< Dog > updateDog(@PathVariable(value = "id") Long id,
//                                           @Valid @RequestBody Dog dogDetails) throws ResourceNotFoundException {
//
//        final Dog updatedDogs = dogsService.updateDogDetails(dogDetails);
//        return ResponseEntity.ok(updatedDogs);
//    }
//
//    @DeleteMapping("/dogs/{id}")
//    public Map< String, Boolean > deleteDog(@PathVariable(value = "id") Long id)
//            throws ResourceNotFoundException {
//        boolean removed = dogsService.removeDog(id);
//
//        Map < String, Boolean > response = new HashMap<>();
//        if( removed )
//            response.put("deleted", Boolean.TRUE);
//        else
//            response.put("deleted", Boolean.FALSE);
//
//        return response;
//    }

}
