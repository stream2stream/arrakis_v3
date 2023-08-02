package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.security;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogHandler implements IDogsService
{
    private DogsRepository itsDogsRepo;

    @Autowired
    public DogHandler( DogsRepository dogRepo )
    {
        itsDogsRepo = dogRepo;
    }

    @Override
    public List<security> getAllDogs()
    {
        return itsDogsRepo.findAll();
    }

    @Override
    public security addDog(security theDog)
    {
        return itsDogsRepo.save( theDog );
    }

    @Override
    public long getNoOfDogs()
    {
        return itsDogsRepo.count();
    }

    @Override
    public boolean removeDog(long uniqueId)
    {
        boolean result = false;

        Optional<security> theDog = itsDogsRepo.findById(uniqueId);
        if(theDog.isPresent())
        {
            itsDogsRepo.delete(theDog.get());
            result = true;
        }

        return  result;
    }

    @Override
    public security getDogById(long uniqueId)
    {
        return itsDogsRepo.findById(uniqueId).get();
    }

    @Override
    public security getDogByName(String dogsName )
    {
        security dogToFind = new security();
        dogToFind.setName(dogsName);
        List<security> dogs = itsDogsRepo.findByName(dogToFind);
        security result = null;

        if( dogs.size() == 1)
            result = dogs.get(0);

        return result;
    }

    @Override
    public security updateDogDetails(security dogToUpdate)
    {
        return itsDogsRepo.save( dogToUpdate );
    }
}
