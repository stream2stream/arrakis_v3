package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeHandler;
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
public class TradeController {
    private TradeHandler TradeService;

    @Autowired
    public TradeController(TradeHandler ds)
    {
        TradeService = ds;
    }


    @GetMapping("/Trades/{id}")
    public ResponseEntity < List<Trade> > getTradesByBookId(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        List<Trade> trades = TradeService.getTradesByBookId(id);
        return ResponseEntity.ok().body(trades);
    }

    @GetMapping("/Trades/BeforeMaturity/{id}")
    public ResponseEntity <List<Trade>> getTradesBeforeMaturity(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException{
        List<Trade> trades = TradeService.getTradesBeforeMaturity(id);
        return ResponseEntity.ok().body(trades);
    }

    @GetMapping("Trades/TradeDisplay/{id}")
    public ResponseEntity <List<String>> getTradeDisplay(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException{
        List<String> trades = TradeService.getTradeDisplay(id);
        return ResponseEntity.ok().body(trades);
    }

    @GetMapping("Trades/MaturityDates/{id}")
    public ResponseEntity <List<String>> getMaturityDates(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException{
        List<String> trades = TradeService.getMaturityDates(id);
        return ResponseEntity.ok().body(trades);
    }

    @GetMapping("Trades/SecurityInfo/{id}")
    public ResponseEntity <List<Object>> getSecurityInfo(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException{
        List<Object> trades = TradeService.getSecurityInfo(id);
        return ResponseEntity.ok().body(trades);
    }

    @GetMapping("Trades/TradesInfo/{id}")
    public ResponseEntity <List<Object>> getTradesInfo(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException{
        List<Object> trades = TradeService.getTradesInfo(id);
        return ResponseEntity.ok().body(trades);
    }

}
