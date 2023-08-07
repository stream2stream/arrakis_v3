package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /* mvp 1.0 story 7
        In order to manage my portfolio of bonds,
        as a user I want to be able to see bonds in books I am responsible for
     */
    @Query(nativeQuery = true, value = "SELECT DISTINCT b.book_id, b.book_name FROM Trade t JOIN Security s ON t.trade_id = s.security_id JOIN Book b ON t.book_id = b.book_id WHERE s.issuer_name = :issuer")
    List<Book> findBook(String issuer);

}
