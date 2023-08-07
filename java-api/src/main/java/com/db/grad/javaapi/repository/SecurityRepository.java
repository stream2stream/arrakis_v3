package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trades;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {

    @Query(nativeQuery = true, value = "select * from security")
    List<Security> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM security s \n" +
            "WHERE DATEDIFF('day', s.maturity_date, '2021-08-02') BETWEEN -5 AND 5\n")
    List<Security> findMaturedBondsForUser();

}
