package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dto.BondDTO;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService {
    @Autowired
    SecurityRepository securityRepository;
    public List<Security> getBonds() {
        return securityRepository.getActiveBonds();
    }
}
