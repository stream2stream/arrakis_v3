package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;

import java.util.List;

public interface ISecurityService
{
    public List<Security> getAllSecurities();

    public Security addSecurity(Security theSecurity);

    public boolean removeSecurity(long id);

    public Security getSecurityByID(long id);


    //public Security getSecurityByIssuerName(String issuerName);



    public Security updateSecurityDetails(Security securityToUpdate);
}
