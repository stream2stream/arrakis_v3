package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trades, Long>
{
    @Query(nativeQuery = true, value = "select * from trade")
    List<Trades> getAllTrades();
}