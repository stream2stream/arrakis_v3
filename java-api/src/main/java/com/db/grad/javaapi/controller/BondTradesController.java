package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.service.BondTradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BondTradesController {
    private BondTradesService bondTradesService;

    @Autowired
    public BondTradesController(BondTradesService theBondTradesService) {
        bondTradesService = theBondTradesService;
    }
}
