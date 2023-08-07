package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trades;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT s.isin, s.cusip, s.issuer_name, s.maturity_date, s.coupon, s.type, s.face_value, s.currency \n" + "FROM security s \n" +
            "JOIN trades t ON t.security_id = s.id \n" +
            "WHERE DATEDIFF('day', s.maturity_date, '2021-08-02') BETWEEN -5 AND 5\n")
    List<User> findMaturedBondsForUser();
}
