package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trades;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from user where name = :name")
    List<User> findAll();
}
