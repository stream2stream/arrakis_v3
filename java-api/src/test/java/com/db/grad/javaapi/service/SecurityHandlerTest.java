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
import static com.db.grad.javaapi.utils.DateUtils.dateFormatter;

import java.time.LocalDate;
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
        when(SecurityRepository.count()).thenReturn(5L);

        long result = SecurityHandler.getNoOfSecurities();

        assertEquals(5L, result);
    }

    @Test
    void testRemoveSecurity() {
        long uniqueId = 1L;
        Security security = createSecurity(uniqueId, "ISIN123", "CUSIP123", "Issuer A", "USD", "active",
                new Date(System.currentTimeMillis()), 2, "GOVN", 1000);
        when(SecurityRepository.findById(uniqueId)).thenReturn(Optional.of(security));

        boolean result = SecurityHandler.removeSecurity(uniqueId);

        assertTrue(result);
    }

    @Test
    void testGetSecurityById() {
        long uniqueId = 1L;
        Security expectedSecurity = createSecurity(uniqueId, "ISIN123", "CUSIP123", "Issuer A", "USD", "active",
                new Date(System.currentTimeMillis()), 2, "GOVN", 1000);
        when(SecurityRepository.findById(uniqueId)).thenReturn(Optional.of(expectedSecurity));

        Security result = SecurityHandler.getSecurityById(uniqueId);

        assertEquals(expectedSecurity, result);
    }

    @Test
    void testGetSecurityByIsin() {
        String isin = "ISIN123";
        Security expectedSecurity = createSecurity(1L, isin, "CUSIP123", "Issuer A", "USD", "active",
                new Date(System.currentTimeMillis()), 2, "Type A", 1000);
        List<Security> securityList = new ArrayList<>();
        securityList.add(expectedSecurity);
        when(SecurityRepository.findByIsin(any(Security.class))).thenReturn(securityList);

        Security result = SecurityHandler.getSecurityByIsin(isin);

        assertEquals(expectedSecurity, result);
    }

    @Test
    void testUpdateSecurityDetails() {
        Security securityToUpdate = createSecurity(1L, "ISIN123", "CUSIP123", "Issuer A", "USD", "active",
                new Date(System.currentTimeMillis()), 2, "Type A", 1000);
        when(SecurityRepository.save(securityToUpdate)).thenReturn(securityToUpdate);

        Security result = SecurityHandler.updateSecurityDetails(securityToUpdate);

        assertEquals(securityToUpdate, result);
    }


    // check this again
    @Test
    void testUpdateSecurityStatus() {
        long id = 1L;
        Security security = createSecurity(id, "ISIN123", "CUSIP123", "Issuer A", "USD", "active",
                new Date(System.currentTimeMillis()), 2, "Type A", 1000);
        when(SecurityRepository.findById(id)).thenReturn(Optional.of(security));

        boolean result = SecurityHandler.updateSecurityStatus(id);

        assertEquals(true, result);
        verify(SecurityRepository, times(1)).save(security);
    }

    @Test
    void testGetSecuritiesByUserDateRange() {
        long userId = 1L;
        String startDateString = "08-01-2023";
        String endDateString = "08-10-2023";
        LocalDate startDate = LocalDate.parse(startDateString, dateFormatter);
        LocalDate endDate = LocalDate.parse(endDateString, dateFormatter);

        java.sql.Date startDateSQL= java.sql.Date.valueOf(startDate);
        java.sql.Date endDateSQL= java.sql.Date.valueOf(endDate);
        List<Security> expectedSecurities = new ArrayList<>();
        when(SecurityRepository.findSecurityByUserDateRange(userId, startDateSQL, endDateSQL))
                .thenReturn(expectedSecurities);

        List<Security> result = SecurityHandler.getSecuritiesByUserDateRange(userId, startDateString, endDateString);

        assertEquals(expectedSecurities, result);
    }

    @Test
    void testGetSecuritiesMatchedWithBook() {
        long userId = 1L;
        List<Security> expectedSecurities = new ArrayList<>();
        when(SecurityRepository.findSecurityByUserBooks(userId)).thenReturn(expectedSecurities);

        List<Security> result = SecurityHandler.getSecuritiesMatchedWithBook(userId);

        assertEquals(expectedSecurities, result);
    }

    @Test
    void testGetDistinctSecurityTypesByUserId() {
        long userId = 1L;
        List<String> expectedTypes = Arrays.asList("Type A", "Type B");
        when(SecurityRepository.findDistinctSecurityTypesByUserId(userId)).thenReturn(expectedTypes);

        List<String> result = SecurityHandler.getDistinctSecurityTypesByUserId(userId);

        assertEquals(expectedTypes, result);
    }

    @Test
    void testGetDistinctSecurityIssuerByUserId() {
        long userId = 1L;
        List<String> expectedIssuers = Arrays.asList("Issuer A", "Issuer B");
        when(SecurityRepository.findDistinctSecurityIssuerByUserId(userId)).thenReturn(expectedIssuers);

        List<String> result = SecurityHandler.getDistinctSecurityIssuerByUserId(userId);

        assertEquals(expectedIssuers, result);
    }

    @Test
    void testGetSecuritiesByDateIssuerAndType() {
        long userId = 1L;
        String startDateString = "08-01-2023";
        String endDateString = "08-01-2023";

        LocalDate startDate = LocalDate.parse(startDateString, dateFormatter);
        LocalDate endDate = LocalDate.parse(endDateString, dateFormatter);

        java.sql.Date startDateSQL= java.sql.Date.valueOf(startDate);
        java.sql.Date endDateSQL= java.sql.Date.valueOf(endDate);

        String issuerName = "Issuer A";
        List<String> issuerNameList = Arrays.asList(issuerName);
        String type = "Type A";
        List<String> typeList = Arrays.asList(type);

        List<Security> expectedSecurities = new ArrayList<>();
        when(SecurityRepository.findSecurityByDateTypeAndIssuer(userId, startDateSQL, endDateSQL, issuerNameList, typeList))
                .thenReturn(expectedSecurities);

        List<Security> result = SecurityHandler.getSecuritiesByDateIssuerAndType(userId, startDateString, endDateString, issuerNameList, typeList);

        assertEquals(expectedSecurities, result);
    }

}



