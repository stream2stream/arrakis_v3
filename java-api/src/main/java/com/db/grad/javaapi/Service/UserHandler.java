package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHandler implements IUserService{

    private UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public long getNoOfUsers() {
        return userRepository.count();
    }

    @Override
    public boolean removeUser(long uniqueId) {
        boolean result = false;

        Optional<User> theUser = userRepository.findById(uniqueId);
        if(theUser.isPresent())
        {
            userRepository.delete(theUser.get());
            result = true;
        }

        return  result;
    }

    @Override
    public User getUserById(long uniqueId) {
        return userRepository.findById(uniqueId).get();
    }

    @Override
    public User getUserByName(String usersName) {
        User userToFind = new User();
        userToFind.setName(usersName);
        List<User> users = userRepository.findByName(userToFind);
        User result = null;

        if( users.size() == 1)
            result = users.get(0);

        return result;
    }

    @Override
    public User updateUserDetails(User userToUpdate) {
        return userRepository.save(userToUpdate);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
