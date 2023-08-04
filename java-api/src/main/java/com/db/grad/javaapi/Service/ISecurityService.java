package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.Security;

import java.util.List;

public interface ISecurityService {
    List<Security> getAllSecurities();

    Security addSecurity(Security theSecurity);

    long getNoOfSecurities();

    boolean removeSecurity(long uniqueId);

    Security getSecurityById(long uniqueId);
    Security getSecurityByIsin(String isin );

    Security updateSecurityDetails(Security securityToUpdate);

}
