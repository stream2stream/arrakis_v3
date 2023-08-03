package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer> {
    @Query(value =
            "SELECT * \n" +
                    "from security as s\n" +
                    "left join book_users as bu \n" +
                    "on s.trading_book_id = bu.trading_book_id\n" +
                    "left join users as u\n" +
                    "on u.id = bu.user_id\n" +
                    "where u.mail = 'user1@db.com'", nativeQuery = true)
    List<Security> findSecuritiesForUserBooks(String userMail);
}
