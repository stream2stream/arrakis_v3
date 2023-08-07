package com.db.grad.javaapi.service;

import com.db.grad.javaapi.Service.SecurityHandler;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class SecurityHandlerTest {

    @Mock
    private SecurityRepository SecurityRepository;

    @InjectMocks
    private SecurityHandler SecurityHandler;

    private Security createSecurity(long id, String isin, String cusip, String issuerName, String currency, String status,
                             Date maturityDate, int coupon, String type, int faceValue) {
        Security security = new Security();
        security.setId(id);
        security.setIsin(isin);
        security.setCusip(cusip);
        security.setIssuer_name(issuerName);
        security.setMaturity_date(maturityDate);
        security.setCoupon(coupon);
        security.setType(type);
        security.setFace_value(faceValue);
        security.setCurrency(currency);
        security.setStatus(status);

        return security;
    }

    @Test
    void testGetAllSecurities() {
        List<Security> securityList = new ArrayList<>();
        securityList.add(createSecurity(1L, "ISIN123", "CUSIP123", "Issuer A", "USD", "active",
                new Date(System.currentTimeMillis()), 2, "Type A", 1000));
        when(SecurityRepository.findAll()).thenReturn(securityList);

        List<Security> result = SecurityHandler.getAllSecurities();

        assertEquals(securityList, result);
    }

    @Test
    void testAddSecurity() {
        Security securityToAdd = createSecurity(1L, "ISIN123", "CUSIP123", "Issuer A", "USD", "active",
                new Date(System.currentTimeMillis()), 2, "Type A", 1000);
        when(SecurityRepository.save(securityToAdd)).thenReturn(securityToAdd);

        Security result = SecurityHandler.addSecurity(securityToAdd);

        assertEquals(securityToAdd, result);
    }

    @Test
    void testGetNoOfSecurities() {
        // ... (test for getNoOfSecurities)
    }

    @Test
    void testRemoveSecurity() {
        // ... (test for removeSecurity)
    }

    @Test
    void testGetSecurityById() {
        // ... (test for getSecurityById)
    }

    @Test
    void testGetSecurityByIsin() {
        // ... (test for getSecurityByIsin)
    }

    @Test
    void testUpdateSecurityDetails() {
        // ... (test for updateSecurityDetails)
    }

    @Test
    void testUpdateSecurityStatus() {
        // ... (test for updateSecurityStatus)
    }

    @Test
    void testGetSecuritiesByUserDateRange() {
        // ... (test for getSecuritiesByUserDateRange)
    }

    @Test
    void testGetSecuritiesMatchedWithBook() {
        // ... (test for getSecuritiesMatchedWithBook)
    }

    @Test
    void testGetDistinctSecurityTypesByUserId() {
        // ... (test for getDistinctSecurityTypesByUserId)
    }

    @Test
    void testGetDistinctSecurityIssuerByUserId() {
        // ... (test for getDistinctSecurityIssuerByUserId)
    }

    @Test
    void testGetSecuritiesByDateIssuerAndType() {
        // ... (test for getSecuritiesByDateIssuerAndType)
    }

}



