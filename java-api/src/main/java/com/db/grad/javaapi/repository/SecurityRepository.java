package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SecurityRepository extends JpaRepository<Security, Integer> {
    @Query("SELECT s FROM Security s WHERE s.status = 'active'")
    List<Security> getActiveBonds();
}
