package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.CounterpartyRepository;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService implements IService<Security>{

    private SecurityRepository securityRepo;

    @Autowired
    public SecurityService(SecurityRepository sr){
        securityRepo = sr;
    }

    @Override
    public List<Security> getAll() {
        return securityRepo.findAll();
    }

    @Override
    public int getNoOf() {
        return (int) securityRepo.count();
    }

    @Override
    public Security getById(Integer uniqueId) {
        return securityRepo.findById(uniqueId).get();
    }

    @Override
    public List<Security> getByName(String issuer) {
        List<Security> result = null;
        List<Security> securities = securityRepo.identifyIsinCusip(issuer);
        if (securities.size() >= 1) {
            result = securities;
        }
        return result;
    }

    public List<Security> getByCusip(String CUSIP){
        List<Security> result = null;
        List<Security> securities = securityRepo.identifyIssuer_cusip(CUSIP);
        if (securities.size() >= 1){
            result = securities;
        }
        return result;
    }
}
