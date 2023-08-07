package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dto.BondTransactionDTO;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepositoryStub;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceLoginTest {

    private UserRepositoryStub userRepo = new UserRepositoryStub();

    @BeforeEach
    public void emptyAllRepos(){
        userRepo.emptyAllData();
    }

    @Test
    public void testLogin(){

        User user1 = new User(1, "user1@db.com", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
        User user2 = new User(2, "user2@db.com", "5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5");

        userRepo.addUser(user1);
        userRepo.addUser(user2);

        UserService userService = new UserService(userRepo);

        boolean result1 = userService.checkLoginDetails("user1@db.com", "1234");
        boolean result2 = userService.checkLoginDetails("user2@db.com", "12345");
        boolean result3 = userService.checkLoginDetails("user1@db.com", "43525");
        boolean result4 = userService.checkLoginDetails("user2@db.com", "1234");


        assertEquals(result1, true);
        assertEquals(result2, true);
        assertEquals(result3, false);
        assertEquals(result4, false);

    }

}
