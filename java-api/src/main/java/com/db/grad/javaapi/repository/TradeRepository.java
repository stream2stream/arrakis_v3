package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    @Query(nativeQuery = true, value = "select * from trades where book_id = :book_id")
    List<Trade> findByBookID(Trade book_id);
}