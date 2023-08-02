package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.security;

import java.util.List;

public interface IDogsService
{
    public List<security> getAllDogs();

    public security addDog(security theDog);

    public long getNoOfDogs();

    public boolean removeDog(long uniqueId);

    public security getDogById(long uniqueId);

    public security getDogByName(String dogsName );

    public security updateDogDetails(security dogToUpdate);
}
