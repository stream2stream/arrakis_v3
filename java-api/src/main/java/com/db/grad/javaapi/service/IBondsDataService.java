package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BondsData;

import java.util.Date;
import java.util.List;

public interface IBondsDataService
{
    List<BondsData> getAll();

    BondsData add(BondsData data);

    long getCount();

    boolean delete(int id);

    BondsData getById(int id);

    List<BondsData> getByHolderName(String name);

    BondsData update(BondsData data);

    List<BondsData> getAllBuys();
    List<BondsData> getAllSells();
    List<BondsData> getByType(String type);
    List<BondsData> getByMaturtiyDate(Date date);

    // TODO: Add more as needed by front-end
}
