package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from users")
    List<User> findAllUsers();

    @Query(nativeQuery = true, value = "select * from users where name = :name")
    User findUser(String name);

    @Query(nativeQuery = true, value = "select BU.book_id from book_users BU JOIN users U ON U.id = BU.users_id where U.name = :name LIMIT 1")
    long getBookId(String name);

}
