package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.text.ParseException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BondServiceTest {

    @InjectMocks
    private BondServiceImpl bondService;

    @Mock
    private BondsRepository bondsRepository;


    @Test
    public void getBondsDueForMaturityPeriod() throws ParseException {
        Bond bond = new Bond();
        bond.setIsin("ISIN1");
        bond.setType("CORP");
        bond.setIssuerID(1);
        Date date = new GregorianCalendar(2023, Calendar.AUGUST, 17).getTime();
        bond.setBondMaturityDate(date);
        bond.setFaceValue(1000);
        bond.setBondCurrency("USD");
        bond.setStatus("active");
        bond.setCusip("CUSIP1");
        Mockito.when(bondsRepository.save(bond)).thenReturn(bond);
        bondsRepository.save(bond);

        Bond bond2 = new Bond();
        bond2.setIsin("ISIN2");
        bond2.setType("GOVN");
        bond2.setIssuerID(1);
        Date date2 = new GregorianCalendar(2023, Calendar.AUGUST, 11).getTime();
        bond2.setBondMaturityDate(date2);
        bond2.setFaceValue(340);
        bond2.setBondCurrency("GBP");
        bond2.setStatus("active");
        bond2.setCusip("CUSIP2");
        Mockito.when(bondsRepository.save(bond2)).thenReturn(bond2);
        bondsRepository.save(bond2);

        Bond bond3 = new Bond();
        bond3.setIsin("ISIN3");
        bond3.setType("SOVN");
        bond3.setIssuerID(1);
        Date date3 = new GregorianCalendar(2023, Calendar.MAY, 15).getTime();
        bond3.setBondMaturityDate(date3);
        bond3.setFaceValue(690);
        bond3.setBondCurrency("USD");
        bond3.setStatus("active");
        bond3.setCusip("CUSIP3");
        Mockito.when(bondsRepository.save(bond3)).thenReturn(bond3);
        bondsRepository.save(bond3);

        Bond bond4 = new Bond();
        bond4.setIsin("ISIN3");
        bond4.setType("SOVN");
        bond4.setIssuerID(1);
        Date date4 = new GregorianCalendar(2023, Calendar.MAY, 16).getTime();
        bond4.setBondMaturityDate(date4);
        bond4.setFaceValue(690);
        bond4.setBondCurrency("USD");
        bond4.setStatus("active");
        bond4.setCusip("CUSIP3");
        Mockito.when(bondsRepository.save(bond4)).thenReturn(bond4);
        bondsRepository.save(bond4);

        Mockito.when(bondsRepository.findAll()).thenReturn(Arrays.asList(bond, bond2, bond3, bond4));

        Map<String, Map<String, Integer>> expectedMap = new HashMap<>();
        Map<String, Integer> date3Map = new HashMap<>();
        date3Map.put("CORP", 1);
        expectedMap.put("17-08-2023", date3Map);
        Map<String, Integer> date4Map = new HashMap<>();
        date4Map.put("GOVN", 1);
        expectedMap.put("11-08-2023", date4Map);

        Map<String, Map<String, Integer>> maturityBonds = bondService.getAllBondsForBusinessDaysBeforeAndAfter("17-08-2023", 5, 5);
        assertEquals(expectedMap, maturityBonds);
    }

}
