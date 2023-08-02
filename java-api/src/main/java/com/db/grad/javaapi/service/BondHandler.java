package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BondHandler implements IBondsSrvice
{
    private BondsRepository itsDogsRepo;

    @Autowired
    public BondHandler(BondsRepository dogRepo )
    {
        itsDogsRepo = dogRepo;
    }

    @Override
    public List<Bond> getAllDogs()
    {
        return itsDogsRepo.findAll();
    }

    @Override
    public Bond addDog(Bond theBond)
    {
        return itsDogsRepo.save(theBond);
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

        Optional<Bond> theDog = itsDogsRepo.findById(uniqueId);
        if(theDog.isPresent())
        {
            itsDogsRepo.delete(theDog.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Bond getDogById(long uniqueId)
    {
        return itsDogsRepo.findById(uniqueId).get();
    }

    @Override
    public Bond getDogByName(String dogsName )
    {
        Bond bondToFind = new Bond();
        bondToFind.setName(dogsName);
        List<Bond> bonds = itsDogsRepo.findByName(bondToFind);
        Bond result = null;

        if( bonds.size() == 1)
            result = bonds.get(0);

        return result;
    }

    @Override
    public Bond updateDogDetails(Bond bondToUpdate)
    {
        return itsDogsRepo.save(bondToUpdate);
    }
}
