package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {


    @Query(nativeQuery = true, value = "select * from book b natural join trades t where b.id = t.book_id and b.id=:id")
    List<Trade> getTradesByBookId(long id);

}
