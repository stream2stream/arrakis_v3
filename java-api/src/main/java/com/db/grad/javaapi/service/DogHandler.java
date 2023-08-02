package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
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
    public List<Security> getAllDogs()
    {
        return itsDogsRepo.findAll();
    }

    @Override
    public Security addDog(Security theDog)
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

        Optional<Security> theDog = itsDogsRepo.findById(uniqueId);
        if(theDog.isPresent())
        {
            itsDogsRepo.delete(theDog.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Security getDogById(long uniqueId)
    {
        return itsDogsRepo.findById(uniqueId).get();
    }

    @Override
    public Security getDogByName(String dogsName )
    {
        Security dogToFind = new Security();
        dogToFind.setName(dogsName);
        List<Security> dogs = itsDogsRepo.findByName(dogToFind);
        Security result = null;

        if( dogs.size() == 1)
            result = dogs.get(0);

        return result;
    }

    @Override
    public Security updateDogDetails(Security dogToUpdate)
    {
        return itsDogsRepo.save( dogToUpdate );
    }
}
