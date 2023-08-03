package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.CounterParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser,Long> {
    List<BookUser> findByBookID(long id );
    List<BookUser> findByUserID(long id );
}