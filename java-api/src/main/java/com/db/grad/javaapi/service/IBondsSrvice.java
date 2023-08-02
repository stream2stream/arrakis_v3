package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;

import java.util.List;

public interface IBondsSrvice
{
    public List<Bond> getAllDogs();

    public Bond addDog(Bond theBond);

    public long getNoOfDogs();

    public boolean removeDog(long uniqueId);

    public Bond getDogById(long uniqueId);

    public Bond getDogByName(String dogsName );

    public Bond updateDogDetails(Bond bondToUpdate);
}
