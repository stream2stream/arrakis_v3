package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BondsData;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondsDataHandler implements IBondsDataService
{
    private BondsRepository repository;

    @Autowired
    public BondsDataHandler(BondsRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<BondsData> getAll() {
        return repository.findAll();
    }

    @Override
    public BondsData add(BondsData data) {
        return repository.save(data);
    }

    @Override
    public long getCount() {
        return repository.count();
    }

    @Override
    public boolean delete(int id) {
        if(repository.existsById(id))
        {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public BondsData getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<BondsData> getByHolderName(String name) {
        return repository.findByHolderName(name);
    }

    @Override
    public BondsData update(BondsData data) {
        return repository.save(data);
    }
}
