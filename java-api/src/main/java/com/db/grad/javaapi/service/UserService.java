package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BondRepository;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
}
