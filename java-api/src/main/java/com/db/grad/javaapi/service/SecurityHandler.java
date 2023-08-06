package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class SecurityHandler {

    @Autowired
    private SecurityRepository securityRepository;

    public List<Security> getAllSecurities(){
        return securityRepository.findAll();
    }

    public boolean isBusinessDay(Date date){
        return date.getDay() != 6 && date.getDay() != 0;
    }

    public List<Security> getSecuritiesByMaturityDate(Date date){
        List<Security> securities = securityRepository.findByMaturityDateNear(date);
        return securities;
    }

}
