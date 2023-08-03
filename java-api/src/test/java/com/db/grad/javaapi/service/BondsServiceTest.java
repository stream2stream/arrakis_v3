package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component ???
public class BondsServiceTest {

    // @Autowired ???
    private BondsRepository bondsRepository;

    @Test
    public void get_bonds_by_maturity() {

        Bond bond = new Bond();
        bond.setBondMaturity("2023-08-03");
    }
}
