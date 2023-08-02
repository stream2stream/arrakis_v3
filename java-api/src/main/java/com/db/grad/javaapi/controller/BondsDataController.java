package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.BondsData;
import com.db.grad.javaapi.service.BondsDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/all")
    public List<BondsData> getByMaturityDate(@RequestParam Date date) {
        return dogsService.getByMaturtiyDate(date);
    }

}
