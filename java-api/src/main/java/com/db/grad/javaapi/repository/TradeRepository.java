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

    @Query(nativeQuery = true, value = "select security.isin, security.maturity_date FROM trades JOIN security ON trades.security_id = security.id where trades.book_id = :id")
    List<String> getTradeDisplay (long id);

    @Query(nativeQuery = true, value = "select security.maturity_date FROM trades JOIN security on trades.book_id = :id WHERE trades.security_id = security.id")
    List<String> getMaturityDates (long id);

    // @Query(nativeQuery = true, value = "SELECT status, currency, face_value, 
    // type coupon, issuer_name from security s natural join Trades t on t. where booking_id = :id secuirty_id = s.id")
    // List<Object> getSecurityInfo (long id);

    // @Query(nativeQuery = true, value = "SELECT currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date from trades where booking_id = :id")
    // List<Object> getTradesInfo (long id);

}
