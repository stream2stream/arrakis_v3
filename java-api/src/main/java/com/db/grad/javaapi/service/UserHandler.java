package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserHandler {
    private UsersRepository itsUsersRepo;

    @Autowired
    public UserHandler(UsersRepository userRepo)
    {
        itsUsersRepo = userRepo;
    }

    public static User getUserByUsername(String username) {
        return getUserByUsername(username);
    }

    public List<User> getAllUsers() {
        return itsUsersRepo.findAll();
    }

    public User addUser(User theUser) {
        return (User) itsUsersRepo.save(theUser);
    }

    public User getUserBySecurityID(long id) {
        return itsUsersRepo.getUserByID(id);
    }

    public boolean removeUser(long id)
    {
        boolean result = false;
        Optional<User> theUser = Optional.ofNullable(itsUsersRepo.findById(id));
        if(theUser.isPresent())
        {
            itsUsersRepo.delete(theUser.get());
            result = true;
        }
        return  result;

    }

    public User getUserByID(long id)
    {
        return itsUsersRepo.findById(id);
    }


    public User updateUserDetails(User UserToUpdate)
    {
        return (User) itsUsersRepo.save( UserToUpdate );
    }
}