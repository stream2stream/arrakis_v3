package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    @Query(nativeQuery = true, value = "select * from trades")
    List<Trade> getAllTrades();

    @Query(nativeQuery = true, value = "select * from trades where book_id = :id")
    List<Trade> getTradeByBookId(long id);


}
