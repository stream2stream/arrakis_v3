package com.db.grad.javaapi.controller;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class TradesController {

    private TradeService tradeService;

    @Autowired
    public TradesController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping(value = {"/trades/isin/{isin}"})
    public List<Trade> getAllTradesByISIN(@PathVariable(value = "isin") String isin) throws ParseException {

        return tradeService.getAllTradesByISIN(isin);
    }
}
