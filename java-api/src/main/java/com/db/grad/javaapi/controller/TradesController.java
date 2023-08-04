package com.db.grad.javaapi.controller;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import com.db.grad.javaapi.service.TradesCounterPartyService;
import com.db.grad.javaapi.utils.Triple;
import com.google.cloud.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = {"/stats/bondHolderId/{bondHolderId}"})
    public Triple<String, Integer, Double> getStatsByBondHolderID(@PathVariable(value = "bondHolderId") int bondHolderId) {
        return tradeService.getStatsByBondHolderID(bondHolderId);
    }
}
