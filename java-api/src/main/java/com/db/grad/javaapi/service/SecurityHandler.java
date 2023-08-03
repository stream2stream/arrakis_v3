package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.addAll;

@Service
public class SecurityHandler implements ISecurityService
{
    private SecurityRepository itsSecuritiesRepo;

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
        Optional<Security> theSecurity = Optional.ofNullable(itsSecuritiesRepo.findById(id));
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
        return itsSecuritiesRepo.findById(id);
    }

    @Override
    public Security getSecurityByIssuerName(String issuerName) {
        return null;
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

    public List<Security> getByDate(int day, int month, int year){
        String date = day+"/"+month+"/"+year;
        List<Security> list = itsSecuritiesRepo.findByBondMaturityDate(date);
        if(day < 10){
            String temp = "0" + date;
            date = temp;
        }
        List<Security> list2 = Stream.concat(list.parallelStream(), itsSecuritiesRepo.findByBondMaturityDate(date).parallelStream())
                .collect(Collectors.toList());
        if(month < 10) {
            String temp = date.substring(0, 3) + "0" + date.substring(3);
            date =temp;
        }
        List<Security> finalList = Stream.concat(list2.parallelStream(), itsSecuritiesRepo.findByBondMaturityDate(date).parallelStream())
                .collect(Collectors.toList());
        System.out.println(date);
        return finalList;
    }
}
