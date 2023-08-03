package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.User;

import java.util.List;

public interface ISecurityInterface {
    List<Security> getAllSecurity();

    Security addSecurity(Security theSecurity);

    long getNoOfSecurity();

    boolean removeSecurity(long uniqueId);

    Security getSecurityById(long uniqueId);
    Security getSecurityByIsin(String isin );

    Security updateSecurityDetails(Security securityToUpdate);

}
