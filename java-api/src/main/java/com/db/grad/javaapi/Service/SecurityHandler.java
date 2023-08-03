package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityHandler implements ISecurityInterface {
    private SecurityRepository securityRepository;
    @Autowired
    public SecurityHandler(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @Override
    public List<Security> getAllSecurity() {
        return securityRepository.findAll();
    }

    @Override
    public Security addSecurity(Security theSecurity) {
        return securityRepository.save(theSecurity);
    }

    @Override
    public long getNoOfSecurity() {
        return securityRepository.count();
    }

    @Override
    public boolean removeSecurity(long uniqueId) {
        boolean result = false;

        Optional<Security> theSecurity = securityRepository.findById(uniqueId);
        if(theSecurity.isPresent())
        {
            securityRepository.delete(theSecurity.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Security getSecurityById(long uniqueId) {
        return securityRepository.findById(uniqueId).get();
    }

    @Override
    public Security getSecurityByIsin(String isin) {
        Security securityToFind = new Security();
        securityToFind.setIsin(isin);
        List<Security> securityList = securityRepository.findByIsin(securityToFind);
        Security result = null;

        if( securityList.size() == 1)
            result = securityList.get(0);

        return result;
    }

    @Override
    public Security updateSecurityDetails(Security securityToUpdate) {
        return securityRepository.save(securityToUpdate);
    }
}