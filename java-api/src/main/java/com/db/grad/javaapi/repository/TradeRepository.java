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

    @Query(nativeQuery = true, value = "SELECT s.maturity_date, s.isin, s.currency, s.face_value, s.type, s.coupon, s.issuer_name, t.currency as t_curr, t.status, t.quantity, t.unit_price, t.buy_sell, t.trade_date, t.settlement_date from security s JOIN Trades t ON t.security_id = s.id AND t.book_id = :id")
    List<Object> getSecurityInfo (long id);

    @Query(nativeQuery = true, value = "SELECT currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date from trades where book_id = :id")
    List<Object> getTradesInfo (long id);

}
