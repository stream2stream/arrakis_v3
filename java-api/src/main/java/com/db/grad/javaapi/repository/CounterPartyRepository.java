package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterPartyRepository extends JpaRepository<CounterParty,Long> {
    CounterParty findById(long id );
}
