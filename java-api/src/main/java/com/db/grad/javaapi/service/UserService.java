package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<User> {

    private UserRepository userRepo;

    @Autowired
    public UserService (UserRepository ur) {
        userRepo = ur;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public int getNoOf() {
        return (int) userRepo.count();
    }

    @Override
    public User getById(Integer uniqueId) {
        return userRepo.findById(uniqueId).get();
    }

    @Override
    public List<User> getByName(String issuer) {
        return null;
    }
}
