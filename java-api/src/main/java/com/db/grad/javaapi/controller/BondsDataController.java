package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.BondsData;
import com.db.grad.javaapi.service.BondsDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bondsdata")
@CrossOrigin(origins = "http://localhost:3000")
public class BondsDataController {
    private BondsDataHandler dogsService;

    @Autowired
    public BondsDataController(BondsDataHandler handler)
    {
        dogsService = handler;
    }

    @GetMapping("/all")
    public List<BondsData> getAllBondsData() {
        return dogsService.getAll();
    }

    @GetMapping("/buys")
    public List<BondsData> getAllBuys() {
        return dogsService.getAllBuys();
    }

    @GetMapping("/sells")
    public List<BondsData> getAllSells() {
        return dogsService.getAllSells();
    }


//    @GetMapping("/dogs")
//    public List <Dog> getAllDogs() {
//        return dogsService.getAll();
//    }
//
//    @GetMapping("/dogs/{id}")
//    public ResponseEntity < Dog > getEmployeeById(@PathVariable(value = "id") Long id)
//    throws ResourceNotFoundException {
//        Dog dogs = dogsService.getDogById(id);
//        return ResponseEntity.ok().body(dogs);
//    }
//
//    @PostMapping("/dogs")
//    public Dog createDog(@Valid @RequestBody Dog dog) {
//        return dogsService.addDog(dog);
//    }
//
//    @PutMapping("/dogs/{id}")
//    public ResponseEntity < Dog > updateDog(@PathVariable(value = "id") Long id,
//        @Valid @RequestBody Dog dogDetails) throws ResourceNotFoundException {
//
//        final Dog updatedDogs = dogsService.updateDogDetails(dogDetails);
//        return ResponseEntity.ok(updatedDogs);
//    }
//
//    @DeleteMapping("/dogs/{id}")
//    public Map < String, Boolean > deleteDog(@PathVariable(value = "id") Long id)
//    throws ResourceNotFoundException {
//    	boolean removed = dogsService.removeDog(id);
//
//        Map < String, Boolean > response = new HashMap <>();
//        if( removed )
//            response.put("deleted", Boolean.TRUE);
//        else
//            response.put("deleted", Boolean.FALSE);
//
//        return response;
//    }
}
