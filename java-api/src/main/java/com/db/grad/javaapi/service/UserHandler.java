package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

    private UserRepository itsUserRepo;

    @Autowired
    public UserHandler(UserRepository userRepo){itsUserRepo = userRepo;}

    public User findUser(String name){
        return itsUserRepo.findUser(name);
    }

    public List<User> getAllUsers(){
        return itsUserRepo.findAll();
    }


}
