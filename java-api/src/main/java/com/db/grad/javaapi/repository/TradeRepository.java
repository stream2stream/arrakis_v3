package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {


    @Query(nativeQuery = true, value = "select * from trades where book_id = :id")
    List<Trade> getTradesByBookId(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM Trades t JOIN Security s ON t.book_id = :id AND s.id = t.security_id AND s.maturity_date > (SELECT CURRENT_TIMESTAMP)")
    List<Trade> getTradesBeforeMaturity (long id);

    @Query(nativeQuery = true, value = "select security.isin, trades.settlement_date, trades.book_id FROM trades JOIN security ON trades.security_id = security.id where trades.book_id = :id")
    List<Trade> getTradeDisplay (long id);


}
