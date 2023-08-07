package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer>
{
    @Query(nativeQuery = true, value = "SELECT * FROM Security s WHERE s.maturity_date = :date")
    List<Security> findByMaturityDate(Date date);

    @Query(nativeQuery = true, value = "SELECT * FROM Security s WHERE DATEDIFF('DAY', :date, s.maturity_date) BETWEEN -5 AND 5")
    List<Security> findByMaturityDateNear(Date date);
}
