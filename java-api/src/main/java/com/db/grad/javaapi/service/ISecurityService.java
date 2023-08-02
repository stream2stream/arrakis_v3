package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;

import java.util.List;

public interface ISecurityService
{
    public List<Security> getAllDogs();

    public Security addDog(Security theDog);

    public long getNoOfDogs();

    public boolean removeDog(long uniqueId);

    public Security getDogById(long uniqueId);

    public Security getDogByName(String dogsName );

    public Security updateDogDetails(Security dogToUpdate);
}
