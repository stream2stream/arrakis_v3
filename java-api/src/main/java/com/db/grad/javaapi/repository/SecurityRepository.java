package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SecurityRepository extends JpaRepository<Security,Long> {
    @Query(nativeQuery = true, value = "select * from security where isin = :isin")
    List<Security> findByIsin(Security isin);

    @Query(nativeQuery = true, value = "select * from security s where s.maturity_date >= startDate and s.maturity_date<=endDate ")
    List<Security> findByMaturityDateBetween(LocalDate startDate, LocalDate endDate);


    @Query(nativeQuery = true, value = "select * from security where id in" +
            "        (select distinct(security_id) from trades\n" +
            "        where book_id in\n" +
            "        (Select book_id from users\n" +
            "        join\n" +
            "        book_users on\n" +
            "        users.id =book_users.users_id\n" +
            "        and users.id = :userID\n" +
            "        join\n" +
            "        book on book.id = book_users.book_id)\n" +
            "        )")
    List<Security> findSecurityByUserBooks(long userID);
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
