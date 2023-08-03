package com.db.grad.javaapi.model;

import com.db.grad.javaapi.repository.BondsRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BondTest {

    private final BondsRepository bondsRepository;

    @Autowired
    BondTest(BondsRepository bondsRepository) {
        this.bondsRepository = bondsRepository;
    }


    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void clearDatabase() {
        bondsRepository.deleteAll();
        entityManager.clear();
        System.out.println(bondsRepository.count()); // should print 7 due to H2 config
    }

    @Test
    public void addBondAndReturnNumberOfBondsInRepo() {
        long currCount = bondsRepository.count();
        Bond bond = new Bond();
        bond.setIsin("ISIN1");
        bond.setType("CORP");
        bond.setIssuerID(1);
        Date date = new Date(2023,01,01);
        bond.setBondMaturityDate(date);
        bond.setFaceValue(1000);
        bond.setBondCurrency("USD");
        bond.setStatus("active");
        bond.setCusip("CUSIP1");
        bondsRepository.save(bond);

        long expectedResult = currCount + 1;
        assertEquals(expectedResult, bondsRepository.count());
    }

    @Test
    public void addSeveralBondsAndReturnNumberOfBondsInRepo() {
        long currCount = bondsRepository.count();
        Bond bond = new Bond();
        bond.setIsin("ISIN1");
        bond.setType("CORP");
        bond.setIssuerID(1);
        Date date = new Date(2023, 01, 01);
        bond.setBondMaturityDate(date);
        bond.setFaceValue(1000);
        bond.setBondCurrency("USD");
        bond.setStatus("active");
        bond.setCusip("CUSIP1");
        bondsRepository.save(bond);

        Bond bond2 = new Bond();
        bond2.setIsin("ISIN2");
        bond2.setType("GOVN");
        bond2.setIssuerID(1);
        Date date2 = new Date(2022, 05, 01);
        bond2.setBondMaturityDate(date2);
        bond2.setFaceValue(340);
        bond2.setBondCurrency("GBP");
        bond2.setStatus("active");
        bond2.setCusip("CUSIP2");
        bondsRepository.save(bond2);

        Bond bond3 = new Bond();
        bond3.setIsin("ISIN3");
        bond3.setType("SOVN");
        bond3.setIssuerID(1);
        Date date3 = new Date(2023, 12, 24);
        bond3.setBondMaturityDate(date2);
        bond3.setFaceValue(690);
        bond3.setBondCurrency("USD");
        bond3.setStatus("active");
        bond3.setCusip("CUSIP3");
        bondsRepository.save(bond3);

        long expectedResult = currCount + 3;
        assertEquals(expectedResult, bondsRepository.count());
    }

    @Test
    public void findBondByValidId(){
        Bond bond = new Bond();
        bond.setIsin("ISIN9");
        bond.setType("CORP");
        bond.setIssuerID(1);
        Date date = new Date(2023, 01, 01);
        bond.setBondMaturityDate(date);
        bond.setFaceValue(1000);
        bond.setBondCurrency("USD");
        bond.setStatus("active");
        bond.setCusip("CUSIP9");
        bondsRepository.save(bond);
        assertEquals(bond.getCusip(), bondsRepository.getReferenceById("ISIN9").getCusip());
    }

}