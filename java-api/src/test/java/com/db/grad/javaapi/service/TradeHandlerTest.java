package com.db.grad.javaapi.service;

import org.junit.jupiter.api.Test;
import com.db.grad.javaapi.model.Trade;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.*;
import com.db.grad.javaapi.repository.TradeRepository;
import com.db.grad.javaapi.model.Trade;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class TradeHandlerTest {

    @Mock 
    private TradeRepository itsTradesRepo;

    @InjectMocks
    private TradeHandler TradeHands;

    @Test
    void testGetAllTrades() {
        Trade newTradeObj = new Trade();
        Mockito.when(itsTradesRepo.save(newTradeObj)).thenReturn(newTradeObj);
        Mockito.when(itsTradesRepo.count()).thenReturn(1L);
        TradeHands.addTrade(newTradeObj);
        int expected = 1;
        long actual = TradeHands.getNoOfTrades();
        assertEquals(expected, actual);
    }
}
