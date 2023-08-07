package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class SecurityServiceTest {
    @Mock
    private SecurityRepository securityRepository;
    @InjectMocks
    private SecurityService securityService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        List<Security> mockSecurities = Arrays.asList(
                new Security(10, "test1", "test11", "test_name1", LocalDateTime.of(2021, 8, 10, 0, 0, 0), 2, "type1", 16, "currency1", "active"),
                new Security(11, "test2", "test22", "test_name2", LocalDateTime.of(2021, 8, 12, 0, 0, 0), 2, "type2", 8, "currency2", "inactive")
        );

        Mockito.when(securityRepository.getActiveBonds()).thenReturn(mockSecurities);

    }

    @Test
    public void testGetActiveBonds() {
        List<Security> activeSecurities = securityService.getBonds();

        Assert.assertEquals(2, activeSecurities.size());
    }

    @Test
    void getBondsForNextFiveDays() {
    }

    @Test
    void getBondsForPreviousFiveDays() {
    }
}