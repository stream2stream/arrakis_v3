package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Bookuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookuserRepository extends JpaRepository<Bookuser, Long> {

    @Query(nativeQuery = true, value = "select * from book_user where name = :name")
    List<Bookuser> findAll();

}
