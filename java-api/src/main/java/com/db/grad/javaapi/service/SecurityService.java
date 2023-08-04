package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private SecurityRepository securityRepository;

    public List<Security> getAllSecuritiesForUserBooks(String userMail){
        return securityRepository.findSecuritiesForUserBooks(userMail);
    }
    public List<Security> getBonds() {
        return securityRepository.getActiveBonds();
    }

    public List<Security> getBondsForNextFiveDays() {
        return securityRepository.getBondsForNextFiveDays();
    }

    public List<Security> getBondsForPreviousFiveDays() {
        return securityRepository.getBondsForPreviousFiveDays();
    }
}
