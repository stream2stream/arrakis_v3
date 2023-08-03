package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserHandler implements UserService {
    private UserRepository itsUserRepo;

    @Autowired
    public UserHandler(UserRepository UserRepo )
    {
        itsUserRepo = UserRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return itsUserRepo.findAll();
    }
}
