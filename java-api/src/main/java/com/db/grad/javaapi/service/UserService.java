package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByFirebaseUserId(String firebaseUserId) {
        return userRepository.findByFirebaseUserId(firebaseUserId);
    }
}

