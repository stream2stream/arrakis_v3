package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradesRepository extends JpaRepository<Trade, Long> {
    //@Query(nativeQuery = true, value = "select * from security where bondMaturityDate = :date")
    //List<Security> findByBondMaturityDate(Security date);
    Trade getTradeBySecurityID(long id);
    Trade  findById( long id );


}