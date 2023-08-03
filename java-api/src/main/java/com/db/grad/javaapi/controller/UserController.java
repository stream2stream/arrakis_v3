package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.Service.UserHandler;
import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    UserHandler userHandler;

    @Autowired
    public UserController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userHandler.getAllUsers();
    }

    @GetMapping("/Users/{id}")
    public ResponseEntity < User > getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        User Users = userHandler.getUserById(id);
        return ResponseEntity.ok().body(Users);
    }

    @PostMapping("/Users")
    public User createUser(@Valid @RequestBody User user) {
        return userHandler.addUser(user);
    }

    @PutMapping("/Users/{id}")
    public ResponseEntity < User > updateUser(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody User UserDetails) throws ResourceNotFoundException {

        final User updatedUsers = userHandler.updateUserDetails(UserDetails);
        return ResponseEntity.ok(updatedUsers);
    }

    @DeleteMapping("/Users/{id}")
    public Map< String, Boolean > deleteUser(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = userHandler.removeUser(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
