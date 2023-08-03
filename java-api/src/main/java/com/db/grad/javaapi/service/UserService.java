package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

@Service
public class UserService {

    private UserRepository currentUserRepo;
    @Autowired
    public UserService(UserRepository userRepo){
        currentUserRepo = userRepo;
    }

    public boolean checkLoginDetails(String mail, String password){
        String hashedPassword = hashPassword(password);
        User searchUser = null;
        List<User> searchUsers = currentUserRepo.findUserForLogin(mail);

        if(searchUsers.size()==1){
            searchUser=searchUsers.get(0);
            String dbPasswordHash = searchUser.getPassword();
            if(hashedPassword==dbPasswordHash){
                return true;
            }
        }
        return false;

    }

    public String hashPassword(String password){
        String hashedPassword = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        return hashedPassword;
    }
}
