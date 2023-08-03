package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsCounterPartiesRepository;
import com.db.grad.javaapi.repository.BondsRepository;
import com.db.grad.javaapi.repository.TradesCounterPartiesRepository;
import com.db.grad.javaapi.repository.TradesRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BondServiceTest {
    @Mock
    private BondsRepository bondsRepository;
    @Mock
    private TradesRepository tradesRepository;
    @Mock
    private TradesCounterPartiesRepository tradesCounterPartiesRepository;
    @Mock
    private BondsCounterPartiesRepository bondsCounterPartiesRepository;

    @InjectMocks
    private BondServiceImpl bondService;



}
