package com.db.grad.javaapi.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.db.grad.javaapi.model.Bond;


import java.util.List;

@SpringBootTest
public class BondRepositoryTest {

    @Autowired
    private BondRepository bondRepository;

    @Test
    public void testFindBondsByBookId() {

        int bookId = 3;

        List<Bond> bonds = bondRepository.findBondsByBookId(bookId);

        System.out.println(bonds.get(0).getId());
    }


}
