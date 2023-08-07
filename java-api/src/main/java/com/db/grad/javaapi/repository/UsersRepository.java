package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from users")
    List<User> findAllUsers();

    @Query(nativeQuery = true, value = "select * from users")
    List<Books> findAllBondsOfUser(User user);

}
