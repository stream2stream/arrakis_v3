package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserHandler {
    @Autowired
    private UserRepository userRepo;

    public int checkEmailAndPassword(String email, String password) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isEmpty())
            return -1;
        else if (!user.get().getPassword().equals(password))
            return -1;
        return user.get().getId();
    }
}
