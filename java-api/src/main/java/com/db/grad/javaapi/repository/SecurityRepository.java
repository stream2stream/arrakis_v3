package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SecurityRepository extends JpaRepository<Security,Long> {
    @Query(nativeQuery = true, value = "select * from security where isin = :isin")
    List<Security> findByIsin(Security isin);
}
