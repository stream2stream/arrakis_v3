package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User addUser(User theUser);

    long getNoOfUsers();

    boolean removeUser(long uniqueId);

    User getUserById(long uniqueId);

    User getUserByName(String usersName );

    User updateUserDetails(User userToUpdate);

}
