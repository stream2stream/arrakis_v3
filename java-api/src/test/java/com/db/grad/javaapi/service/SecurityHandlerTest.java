package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.repository.SecurityRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityHandlerTest {

    @BeforeEach
    void setUp() {

    }

    private SecurityRepository securityRepo = new SecurityRepositoryStub();

    @Test
    void getAllSecurities() {
        //arrange
        SecurityHandler cut = new SecurityHandler(securityRepo);
        Security theSecurity = new Security();
        theSecurity.setIssuerName("Mark");
        theSecurity.setId(1);
        theSecurity.setBondCurrency("dollar");
        theSecurity.setBondMaturityDate("23/10/2023");
        cut.addSecurity(theSecurity);

        boolean expectedResult = true;
        boolean actualResult = false;

        //act
        if (cut.getAllSecurities() != null)
            actualResult = true;
        else
            actualResult = false;

        //assert
        assertEquals( expectedResult, actualResult );

    }

    @Test
    void addSecurity() {
    }

    @Test
    void removeSecurity() {
    }

    @Test
    void getSecurityByID() {
    }

    @Test
    void updateSecurityDetails() {
    }
}