package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "select * from users where mail = :mail")
    List<User> findUserForLogin(String mail);
}
