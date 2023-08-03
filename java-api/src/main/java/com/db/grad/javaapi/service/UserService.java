package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }


    public List<User> getAllUsers() {
        return ur.findAll();
    }

    public User findById(int userId){
        return ur.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public void save(User user) {
        ur.save(user);
    }

    public User addUserByUsername(String username) {
        User user = new User();
        user.setUserName(username);
        return ur.save(user);
    }
}