package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityHandler implements ISecurityService
{
    private SecurityRepository itsSecuritiesRepo;

    @Autowired
    public SecurityHandler(SecurityRepository securityRepo )
    {
        itsSecuritiesRepo = securityRepo;
    }

    @Override
    public List<Security> getAllSecurities()
    {
        return itsSecuritiesRepo.findAll();
    }

    @Override
    public Security addSecurity(Security theSecurity)
    {
        return itsSecuritiesRepo.save( theSecurity );
    }

    @Override
    public boolean removeSecurity(long id)
    {
        boolean result = false;
        Optional<Security> theSecurity = itsSecuritiesRepo.findById(id);
        if(theSecurity.isPresent())
        {
            itsSecuritiesRepo.delete(theSecurity.get());
            result = true;
        }
        return  result;
    }

    @Override
    public Security getSecurityByID(long id)
    {
        return itsSecuritiesRepo.findById(id).get();
    }

    /* @Override
      public Security getSecurityByIssuerName(String issuerName )
     {
          Security securityToFind = new Security();
          securityToFind.setIssuerName(issuerName);
          List<Security> securities = itsSecuritiesRepo.findByIssuerName(securityToFind);
          Security result = null;

          if( securities.size() == 1)
              result = securities.get(0);

          return result;
      }*/
    @Override
    public Security updateSecurityDetails(Security securityToUpdate)
    {
        return itsSecuritiesRepo.save( securityToUpdate );
    }
}
