package com.db.grad.javaapi.controller;
import com.db.grad.javaapi.model.Bond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.db.grad.javaapi.service.AppService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private AppService as ;
    @Autowired
    public UserController(AppService as)
    {
        this.as = as;
    }

    @GetMapping("/RedeemBond")
    public Boolean redeemBond(Integer bondId){
        return as.redeemBondById(bondId) ;
    }
}
