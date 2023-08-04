package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

    @Query(value="SELECT * FROM trades", nativeQuery = true)
    List<Trade> getAllTransactions();
}
