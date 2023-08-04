package com.db.grad.javaapi.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.UsersRepository;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @MockBean
    private UsersRepository usersRepository;

    @Test
    @DisplayName("Test registerUser")
    void testRegisterUser() {
        Users user = new Users();
        user.setPassword("password");
        user.setUsername("username");
        doReturn(user).when(usersRepository).save(user);

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        Assertions.assertEquals(user, usersService.registerUser(user));
    }

    @Test
    @DisplayName("Test loadUserByUsername")
    void testLoadUserByUsername() {
        Users user = new Users();
        user.setUsername("mock");
        user.setPassword("password");
        doReturn(user).when(usersRepository).findUserByUsername("mock");

        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRole());

        Assertions.assertEquals(userBuilder.build(), usersService.loadUserByUsername("mock"));
    }
}
