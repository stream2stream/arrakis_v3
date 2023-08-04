package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public int login(String username, String password) {

        List<User> users = usersRepository.findUser(username);

        if(users.size() != 1)
            return -1;

        User user = users.get(0);

        return user.getPassword().equals(password) ? user.getId() : 0;
    }
}
