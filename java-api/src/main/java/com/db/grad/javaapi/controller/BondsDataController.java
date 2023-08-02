package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.BondsData;
import com.db.grad.javaapi.service.BondsDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    // TODO: Find all bonds from past and next 5 days from date.
    @GetMapping("/all/{date}")
    public List<BondsData> getByMaturityDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        return dogsService.getByMaturityDate(date);
    }

    @GetMapping("/all/bookName/{bookName}")
    public List<BondsData> getByBookName(@PathVariable String bookName) {
        return dogsService.getByBookName(bookName);
    }
    @GetMapping("/all/ISIN/{isin}")
    public List<BondsData> getByIsin(@PathVariable String isin) {
        return dogsService.getBondByISIN(isin);
    }
}
