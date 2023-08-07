package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

    /*  mvp 1.0 story 4
        In order to be able to uniquely identify bond trades,
        as a user I want to be able to see a Bond’s ISIN and CUSIP code
     */
    @Query(nativeQuery = true, value = "SELECT trade_id, book_id, bond_holder_id, trade_date, trade_settlement_date, trade_type, trade_currency, trade_status, unit_price, quantity, s.isin, s.cusip FROM Security s JOIN Trade t ON t.trade_id = s.security_id WHERE s.issuer_name = :issuer")
    List<Trade> identifyIsinCusip(String issuer);









}
