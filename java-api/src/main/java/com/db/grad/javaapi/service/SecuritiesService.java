package com.db.grad.javaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecuritiesRepository;

@Service
public class SecuritiesService {

    @Autowired
    private SecuritiesRepository repo;

    public List<Security> getAllSecurities() {
        return repo.findAll();
    }

    public Security getSecurityById(@PathVariable(value = "id") Integer id) {
        return repo.findById(id).get();
    }

}
