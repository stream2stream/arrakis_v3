package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(nativeQuery = true, value = "select * from book where name = :name")
    List<Book> findByName(Book name);

    @Query(nativeQuery = true, value = "\n" +
            "SELECT *\n" +
            "FROM book\n" +
            "WHERE id IN (\n" +
            "    SELECT book_id\n" +
            "    FROM users\n" +
            "    JOIN book_users ON users.id = book_users.users_id\n" +
            "    WHERE users.id = :userId\n" +
            ");")
    List<Book> getAllBooksByUserID(long userId);
}


