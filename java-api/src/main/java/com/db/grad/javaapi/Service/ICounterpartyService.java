package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.model.User;

import java.util.List;

public interface ICounterpartyService {
    List<Counterparty> getAllCounterparties();

    Counterparty addCounterparty(Counterparty theCounterparty);

    long getNoOfCounterparties();

    boolean removeCounterparty(long uniqueId);

    Counterparty getCounterpartyById(long uniqueId);

    Counterparty getCounterpartyByName(String counterpartyName );

    Counterparty updateCounterpartyDetails(Counterparty counterpartyToUpdate);

}
