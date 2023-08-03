package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(nativeQuery = true, value = "select * from book where name = :name")
    List<Book> findByName(Book name);
}
/* select * from security where id in
        (select distinct(security_id) from trade
        where book_id in
        (Select book_id from users
        join
        book_users on
        users.id =book_users.users_id
        and users.id = :userID
        join
        book on book.id = book_users.book_id)
        )
       */
