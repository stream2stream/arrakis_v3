package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT DISTINCT b.*" +
            "FROM Book b" +
            "INNER JOIN book_users bu ON b.id = bu.book_id" +
            "INNER JOIN user u ON u.user_id = bu.user_id" +
            "WHERE u.mail = :userMail", nativeQuery = true)
    List<Book> findBooksByUserId(@Param("userMail") String userMail);
}
