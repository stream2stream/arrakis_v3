package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BondsCounterParty;
import com.db.grad.javaapi.repository.BondsCounterPartiesRepository;
import com.db.grad.javaapi.repository.BondsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BondsCounterPartyServiceTest {

    @InjectMocks
    private BondsCounterPartyServiceImpl bondsCounterPartyService;

    @Mock
    private BondsCounterPartiesRepository bondsCounterPartiesRepository;

    @Test
    public void getIssuerNameByID(){
        BondsCounterParty bondsCounterParty1 = new BondsCounterParty();
        bondsCounterParty1.setIssuerName("Issuer1");
        bondsCounterParty1.setId(20);
        Mockito.when(bondsCounterPartiesRepository.save(bondsCounterParty1)).thenReturn(bondsCounterParty1);
        bondsCounterPartiesRepository.save(bondsCounterParty1);

        BondsCounterParty bondsCounterParty2 = new BondsCounterParty();
        bondsCounterParty2.setIssuerName("Issuer2");
        bondsCounterParty2.setId(21);
        Mockito.when(bondsCounterPartiesRepository.save(bondsCounterParty2)).thenReturn(bondsCounterParty2);
        bondsCounterPartiesRepository.save(bondsCounterParty2);

        BondsCounterParty bondsCounterParty3 = new BondsCounterParty();
        bondsCounterParty2.setIssuerName("Issuer3");
        bondsCounterParty2.setId(22);
        Mockito.when(bondsCounterPartiesRepository.save(bondsCounterParty3)).thenReturn(bondsCounterParty3);
        bondsCounterPartiesRepository.save(bondsCounterParty3);

        Mockito.when(bondsCounterPartiesRepository.findAll()).thenReturn(Arrays.asList(bondsCounterParty1, bondsCounterParty2, bondsCounterParty3));
        String expectedNameRes = "Issuer3";

        String actualNameRes = bondsCounterPartyService.getIssuerNameByID(22);

        assertEquals(expectedNameRes, actualNameRes);
    }
}
