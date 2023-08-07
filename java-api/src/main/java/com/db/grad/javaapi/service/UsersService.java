package com.db.grad.javaapi.service;

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

    public void addNewUser(String email, String username, String password, String role) {
        if(email == null || username == null || password == null || role == null) {
            return;
        }
        usersRepository.addUser(username, password, email, role);
    }

    public List<User> findUserByEmail(String email) {
        //Parsable/Searchable strings only
        if(email == null) {
            return null;
        }

        //SQL query to search user by email
        return usersRepository.findUserByEmail(email);
    }

    public int findUserId(String email, String username) {
        //Parsable/Searchable strings only
        if(email == null || username == null) {
            return -1;
        }

        //SQL query to search user by email
        List<User> users = usersRepository.findUserByEmail(email);

        //No match on email
        if (users.size() != 1) {
            return -1;
        }
        //Search through list of users for matching username
        for(User u: users) {
            if(u.getUsername().equals(username)) {
                return u.getId();
            }
        }

        //Match on email, but none matching username
        return 0;
    }

    public boolean updateUserPwd(String password, int id) {
        //Valid user id only
        if(id < 1) {
            return false;
        }

        //Note: Checking if id exists in table does not matter,
        //since sql's UPDATE command will not insert/change a row
        //that does not match the given id (WHERE conditions)

        //Successful update returns an updated row (since id is unique)
        return (usersRepository.updateUserPwd(password, id).size() == 1);
    }
}
