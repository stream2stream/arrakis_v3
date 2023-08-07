package com.db.grad.javaapi.service;

import com.db.grad.javaapi.Service.UserHandler;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserHandlerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserHandler userHandler;

    //create user method
    private User createUser(Long id, String name, String email, String role) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setRole(role);
        return user;
    }
    @Test
    public void testGetAllUsers() {
        // Arrange
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(createUser(1L, "Andreea", "andreea@example.com", "admin"));
        expectedUsers.add(createUser(2L, "Unays", "unays@example.com", "admin"));
        when(userRepository.findAll()).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userHandler.getAllUsers();

        // Assert
        assertNotNull(actualUsers);
        assertEquals(expectedUsers.size(), actualUsers.size());
        for (int i = 0; i < expectedUsers.size(); i++) {
            User expectedUser = expectedUsers.get(i);
            User actualUser = actualUsers.get(i);
            assertEquals(expectedUser.getId(), actualUser.getId());
            assertEquals(expectedUser.getName(), actualUser.getName());
            assertEquals(expectedUser.getEmail(), actualUser.getEmail());
            assertEquals(expectedUser.getRole(), actualUser.getRole());
        }
    }
    @Test
    public void testAddUser() {
        // Arrange
        User newUser = new User();
        newUser.setId(1L);
        newUser.setName("Kalu");
        newUser.setEmail("kaluthechief@email.com");
        newUser.setRole("admin");

        when(userRepository.save(newUser)).thenReturn(newUser);

        // Act
        User addedUser = userHandler.addUser(newUser);

        // Assert
        assertNotNull(addedUser);
        assertEquals(newUser.getId(), addedUser.getId());
        assertEquals(newUser.getName(), addedUser.getName());
        assertEquals(newUser.getEmail(), addedUser.getEmail());
        assertEquals(newUser.getRole(), addedUser.getRole());
    }

    @Test
    public void testGetNoOfUsers() {
        // Arrange
        long expectedCount = 5;
        when(userRepository.count()).thenReturn(expectedCount);

        // Act
        long actualCount = userHandler.getNoOfUsers();

        // Assert
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testRemoveUser_UserExists() {
        // Arrange
        long userIdToRemove = 1L;
        User userToRemove = new User();
        userToRemove.setId(userIdToRemove);
        when(userRepository.findById(userIdToRemove)).thenReturn(Optional.of(userToRemove));

        // Act
        boolean result = userHandler.removeUser(userIdToRemove);

        // Assert
        assertTrue(result);
        verify(userRepository, times(1)).delete(userToRemove);
    }

    @Test
    public void testRemoveUser_UserDoesNotExist() {
        // Arrange
        long userIdToRemove = 1L;
        when(userRepository.findById(userIdToRemove)).thenReturn(Optional.empty());

        // Act
        boolean result = userHandler.removeUser(userIdToRemove);

        // Assert
        assertFalse(result);
        verify(userRepository, never()).delete(any());
    }

    @Test
    public void testGetUserById_UserExists() {
        // Arrange
        long userIdToRetrieve = 1L;
        User expectedUser = Mockito.mock(User.class);
        when(userRepository.findById(userIdToRetrieve)).thenReturn(Optional.of(expectedUser));

        // Act
        User actualUser = userHandler.getUserById(userIdToRetrieve);

        // Assert
        assertEquals(expectedUser, actualUser);
    }
/*
    @Test
    public void testGetUserById_UserDoesNotExist() {
        // Arrange
        long userIdToRetrieve = 1L;
        when(userRepository.findById(userIdToRetrieve)).thenReturn(Optional.empty());

        // Act
        User actualUser = userHandler.getUserById(userIdToRetrieve);

        // Assert
        assertNull(actualUser);
    }
 */
    @Test
    public void testGetUserByName_UserExists() {
    // Arrange
    String userNameToFind = "Kalu";
    User userToFind = new User();
    userToFind.setId(1L);
    userToFind.setName(userNameToFind);
    userToFind.setEmail("kaluthechief@email.com");
    userToFind.setRole("admin");

    List<User> users = new ArrayList<>();
    users.add(userToFind);
    when(userRepository.findByName(any())).thenReturn(users);

    // Act
    User actualUser = userHandler.getUserByName(userNameToFind);

    // Assert
    assertNotNull(actualUser);
    assertEquals(userToFind.getId(), actualUser.getId());
    assertEquals(userToFind.getName(), actualUser.getName());
    assertEquals(userToFind.getEmail(), actualUser.getEmail());
    assertEquals(userToFind.getRole(), actualUser.getRole());
}

    @Test
    public void testGetUserByName_UserDoesNotExist() {
        // Arrange
        String userNameToFind = "NoUser";
        when(userRepository.findByName(any())).thenReturn(Collections.emptyList());

        // Act
        User actualUser = userHandler.getUserByName(userNameToFind);

        // Assert
        assertNull(actualUser);
    }
    @Test
    public void testUpdateUserDetails() {
        // Arrange
        User userToUpdate = createUser(1L, "Kalu", "kaluthechief@example.com", "admin");
        when(userRepository.save(any(User.class))).thenReturn(userToUpdate);

        // Act
        User updatedUser = userHandler.updateUserDetails(userToUpdate);

        // Assert
        assertNotNull(updatedUser);
        assertEquals(userToUpdate.getId(), updatedUser.getId());
        assertEquals(userToUpdate.getName(), updatedUser.getName());
        assertEquals(userToUpdate.getEmail(), updatedUser.getEmail());
        assertEquals(userToUpdate.getRole(), updatedUser.getRole());
    }

    @Test
    public void testGetUserByEmail_UserExists() {
        // Arrange
        String emailToFind = "kaluthechief@email.com";
        User userToFind = createUser(1L, "Kalu", emailToFind, "admin");
        when(userRepository.getUserByEmail(emailToFind)).thenReturn(userToFind);

        // Act
        User actualUser = userHandler.getUserByEmail(emailToFind);

        // Assert
        assertNotNull(actualUser);
        assertEquals(userToFind.getId(), actualUser.getId());
        assertEquals(userToFind.getName(), actualUser.getName());
        assertEquals(userToFind.getEmail(), actualUser.getEmail());
        assertEquals(userToFind.getRole(), actualUser.getRole());
    }

    @Test
    public void testGetUserByEmail_UserDoesNotExist() {
        // Arrange
        String emailToFind = "nonexistent@example.com";
        when(userRepository.getUserByEmail(emailToFind)).thenReturn(null);

        // Act
        User actualUser = userHandler.getUserByEmail(emailToFind);

        // Assert
        assertNull(actualUser);
    }


}
