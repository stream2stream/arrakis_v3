package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, String>
{
    @Query(nativeQuery = true, value = "select * from books where book_number = :bookNumber")
    List<Books> findByNumber(String bookNumber);
}