package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterpartyRepository extends JpaRepository<Counterparty, Integer> {

    /* mvp 1.0 story 6
        In order to identify who currently owns the bond,
        as a user I want to be able to see the client name of the bond
     */
    @Query(nativeQuery = true, value = "SELECT DISTINCT c.bond_holder FROM Trade t JOIN Counterparty c ON t.bond_holder_id = c.bond_holder_id\n" +
            "JOIN Security s ON t.trade_id = s.security_id\n" +
            "WHERE s.issuer_name = :issuer;")
    List<Trade> findClientName(String issuer);
}
