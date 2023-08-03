package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component ???

@ExtendWith(MockitoExtension.class)
public class BondsServiceTest {

    @Mock
    private BondsRepository bondsRepository;

    @InjectMocks
    private BondsService cut;

    @Test
    public void get_bonds_by_maturity() {

    }
}
