package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.TradesCounterParty;
import com.db.grad.javaapi.repository.BondsRepository;
import com.db.grad.javaapi.repository.TradesCounterPartiesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TradesCounterPartyServiceTest {
    @InjectMocks
    private TradesCounterPartyServiceImpl tradesCounterPartyService;

    @Mock
    private TradesCounterPartiesRepository tradesCounterPartiesRepository;

    @Test
    public void getHolderNameByID() {
        TradesCounterParty tradesCounterParty1 = new TradesCounterParty();
        tradesCounterParty1.setBondHolderName("BondsBrigade");
        tradesCounterParty1.setId(12);
        Mockito.when(tradesCounterPartiesRepository.save(tradesCounterParty1)).thenReturn(tradesCounterParty1);
        tradesCounterPartiesRepository.save(tradesCounterParty1);

        TradesCounterParty tradesCounterParty2 = new TradesCounterParty();
        tradesCounterParty2.setBondHolderName("TradesBrigade");
        tradesCounterParty2.setId(13);
        Mockito.when(tradesCounterPartiesRepository.save(tradesCounterParty2)).thenReturn(tradesCounterParty2);
        tradesCounterPartiesRepository.save(tradesCounterParty2);

        TradesCounterParty tradesCounterParty3 = new TradesCounterParty();
        tradesCounterParty2.setBondHolderName("MyBrigade");
        tradesCounterParty2.setId(14);
        Mockito.when(tradesCounterPartiesRepository.save(tradesCounterParty3)).thenReturn(tradesCounterParty3);
        tradesCounterPartiesRepository.save(tradesCounterParty3);

        Mockito.when(tradesCounterPartiesRepository.findAll()).thenReturn(Arrays.asList(tradesCounterParty1, tradesCounterParty2, tradesCounterParty3));
        String expectedNameRes = "BondsBrigade";
        String actualNameRes = tradesCounterPartyService.getBondHolderNameByID(1);
        System.out.println(tradesCounterPartyService);
        assertEquals(expectedNameRes, actualNameRes);
    }
}
