package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Trades;
import com.db.grad.javaapi.service.TradeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TradeController {
    private TradeHandler TradeService;

    @Autowired
    public TradeController(TradeHandler bs)
    {
        TradeService = bs;
    }

    @GetMapping("/trades")
    public List <Trades> getAllTrades() {return TradeService.getAllTrades();}

    @GetMapping("/trades/{id}")
    public ResponseEntity <Trades> getEmployeeById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Trades trade = TradeService.getTradesById(id);
        return ResponseEntity.ok().body(trade);
    }

    @PostMapping("/trades")
    public Trades createTrade(@RequestBody Trades trade) {
        return TradeService.addTrade(trade);
    }

    @PutMapping("/trades/{id}")
    public ResponseEntity < Trades > updateTrade(@PathVariable(value = "id") Long id,
         @RequestBody Trades trade) throws ResourceNotFoundException {

        final Trades updatedTrades = TradeService.updateTradeDetails(trade);
        return ResponseEntity.ok(updatedTrades);
    }

    @DeleteMapping("/trades/{id}")
    public Map < String, Boolean > deleteTrade(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException {
    	boolean removed = TradeService.removeTrade(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
