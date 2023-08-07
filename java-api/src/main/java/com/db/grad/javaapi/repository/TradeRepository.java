package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trades, Long>
{
    @Query(nativeQuery = true, value = "select * from trades")
    List<Trades> getAllTrades();

    @Query(nativeQuery = true, value = "SELECT books.*, tradetype FROM trades LEFT JOIN books ON books.bookid = trades.bookid WHERE CAST(:date as DATE) < CAST(PARSEDATETIME(books.BONDMATURITYDATE, 'dd-MM-yy') AS DATE);")
    List<String> showRedeemableBonds(String date);
}