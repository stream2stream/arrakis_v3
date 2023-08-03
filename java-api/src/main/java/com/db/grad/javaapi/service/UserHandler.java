package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trades;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.TradesRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserHandler implements IUserService {

    private UserRepository itsUserRepo;

    @Autowired
    public UserHandler( UserRepository userRepo )
    {
        itsUserRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers()
    {
        return itsUserRepo.findAll();
    }

}
