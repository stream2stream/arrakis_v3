package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Counterparty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CounterpartyRepository extends JpaRepository<Counterparty,Long> {
    @Query(nativeQuery = true, value = "select * from counterparty where name = :name")
    List<Counterparty> findByName(Counterparty name);
}
