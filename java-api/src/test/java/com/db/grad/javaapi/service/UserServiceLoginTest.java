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

        User user1 = new User(1, "user1@db.com", "1234");
        userRepo.addUser(user1);

        UserService userService = new UserService(userRepo);
        boolean result = userService.checkLoginDetails()


        assertEquals(resulDto.get(0).getTransactions().isEmpty(), true);
        assertEquals(resulDto.get(0).getSecurity(), security1);

    }

}
