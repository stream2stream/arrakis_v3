package com.db.grad.javaapi.service;

import com.db.grad.javaapi.Service.CounterpartyHandler;
import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.repository.CounterpartyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class CounterpartyHandlerTest {
    @Mock
    private CounterpartyRepository counterpartyRepository;

    @InjectMocks
    private CounterpartyHandler counterpartyHandler;

    // create counterparty method (id, name)
    private Counterparty createCounterparty(long id, String name) {
        Counterparty counterparty = new Counterparty();
        counterparty.setId(id);
        counterparty.setName(name);
        return counterparty;
    }
    // create counterparty method (name)
    private Counterparty createCounterparty(String name) {
        Counterparty counterparty = new Counterparty();
        counterparty.setName(name);
        return counterparty;
    }
    @Test
    public void testGetAllCounterparties() {
        // Arrange
        List<Counterparty> expectedCounterparties = new ArrayList<>();
        expectedCounterparties.add(createCounterparty(1L, "AZ Holdings Inc"));
        expectedCounterparties.add(createCounterparty(2L, "Acme co"));
        when(counterpartyRepository.findAll()).thenReturn(expectedCounterparties);

        // Act
        List<Counterparty> actualCounterparties = counterpartyHandler.getAllCounterparties();

        // Assert
        assertEquals(expectedCounterparties.size(), actualCounterparties.size());
        for (int i = 0; i < expectedCounterparties.size(); i++) {
            Counterparty expectedCounterparty = expectedCounterparties.get(i);
            Counterparty actualCounterparty = actualCounterparties.get(i);
            assertEquals(expectedCounterparty.getId(), actualCounterparty.getId());
            assertEquals(expectedCounterparty.getName(), actualCounterparty.getName());
        }
    }
    @Test
    public void testAddCounterparty() {
        // Arrange
        Counterparty newCounterparty = createCounterparty("New Counterparty");
        when(counterpartyRepository.save(newCounterparty)).thenReturn(newCounterparty);

        // Act
        Counterparty addedCounterparty = counterpartyHandler.addCounterparty(newCounterparty);

        // Assert
        assertEquals(newCounterparty.getId(), addedCounterparty.getId());
        assertEquals(newCounterparty.getName(), addedCounterparty.getName());
    }
    @Test
    public void testGetNoOfCounterparties() {
        // Arrange
        long expectedCount = 5;
        when(counterpartyRepository.count()).thenReturn(expectedCount);

        // Act
        long actualCount = counterpartyHandler.getNoOfCounterparties();

        // Assert
        assertEquals(expectedCount, actualCount);
    }
    @Test
    public void testRemoveCounterparty_CounterpartyExists() {
        // Arrange
        long counterpartyIdToRemove = 1L;
        Counterparty counterpartyToRemove = new Counterparty();
        counterpartyToRemove.setId(counterpartyIdToRemove);
        when(counterpartyRepository.findById(counterpartyIdToRemove)).thenReturn(Optional.of(counterpartyToRemove));

        // Act
        boolean result = counterpartyHandler.removeCounterparty(counterpartyIdToRemove);

        // Assert
        assertTrue(result);
        verify(counterpartyRepository).delete(counterpartyToRemove);
    }

    @Test
    public void testRemoveCounterparty_CounterpartyDoesNotExist() {
        // Arrange
        long counterpartyIdToRemove = 1L;
        when(counterpartyRepository.findById(counterpartyIdToRemove)).thenReturn(Optional.empty());

        // Act
        boolean result = counterpartyHandler.removeCounterparty(counterpartyIdToRemove);

        // Assert
        assertFalse(result);
        verify(counterpartyRepository, never()).delete(any());
    }
    @Test
    public void testGetCounterpartyById_CounterpartyExists() {
        // Arrange
        long counterpartyId = 1L;
        Counterparty expectedCounterparty = new Counterparty();
        expectedCounterparty.setId(counterpartyId);
        expectedCounterparty.setName("Sovereign Investments");

        when(counterpartyRepository.findById(counterpartyId)).thenReturn(Optional.of(expectedCounterparty));

        // Act
        Counterparty actualCounterparty = counterpartyHandler.getCounterpartyById(counterpartyId);

        // Assert
        assertNotNull(actualCounterparty);
        assertEquals(expectedCounterparty.getId(), actualCounterparty.getId());
        assertEquals(expectedCounterparty.getName(), actualCounterparty.getName());
    }

    @Test
    public void testGetCounterpartyById_CounterpartyDoesNotExist() {
        // Arrange
        long counterpartyId = 1L;
        when(counterpartyRepository.findById(counterpartyId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> counterpartyHandler.getCounterpartyById(counterpartyId));
    }

    @Test
    public void testGetCounterpartyByName_CounterpartyExists() {
        // Arrange
        String counterpartyName = "AZ Holdings Inc";
        Counterparty expectedCounterparty = new Counterparty();
        expectedCounterparty.setId(1L);
        expectedCounterparty.setName(counterpartyName);

        List<Counterparty> counterparties = new ArrayList<>();
        counterparties.add(expectedCounterparty);
        when(counterpartyRepository.findByName(any())).thenReturn(counterparties);

        // Act
        Counterparty actualCounterparty = counterpartyHandler.getCounterpartyByName(counterpartyName);

        // Assert
        assertNotNull(actualCounterparty);
        assertEquals(expectedCounterparty.getId(), actualCounterparty.getId());
        assertEquals(expectedCounterparty.getName(), actualCounterparty.getName());
    }

    @Test
    public void testGetCounterpartyByName_CounterpartyDoesNotExist() {
        // Arrange
        String counterpartyName = "NotACounterparty";
        when(counterpartyRepository.findByName(any())).thenReturn(new ArrayList<>());

        // Act
        Counterparty actualCounterparty = counterpartyHandler.getCounterpartyByName(counterpartyName);

        // Assert
        assertNull(actualCounterparty);
    }

    @Test
    public void testUpdateCounterpartyDetails() {
        // Arrange
        Counterparty counterpartyToUpdate = new Counterparty();
        counterpartyToUpdate.setId(1L);
        counterpartyToUpdate.setName("Updated_Counterparty");

        when(counterpartyRepository.save(any(Counterparty.class))).thenReturn(counterpartyToUpdate);

        // Act
        Counterparty updatedCounterparty = counterpartyHandler.updateCounterpartyDetails(counterpartyToUpdate);

        // Assert
        assertNotNull(updatedCounterparty);
        assertEquals(counterpartyToUpdate.getId(), updatedCounterparty.getId());
        assertEquals(counterpartyToUpdate.getName(), updatedCounterparty.getName());
    }
}


