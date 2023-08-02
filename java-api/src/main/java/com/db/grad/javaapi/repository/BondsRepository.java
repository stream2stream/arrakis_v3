package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BondsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BondsRepository extends JpaRepository<BondsData, Integer>
{
    // UPPER ==> Case insensitive queries
    @Query(nativeQuery = true, value = "select * from bondsdata where UPPER(bond_holder) = UPPER(:tradeType)")
    List<BondsData> findByHolderName(String tradeType);

    @Query(nativeQuery = true, value = "select * from bondsdata where UPPER(type) = UPPER(:type)")
    List<BondsData> findByType(String type);

    @Query(nativeQuery = true, value = "select * from bondsdata where UPPER(trade_type) = UPPER('buy')")
    List<BondsData> getBuys();

    @Query(nativeQuery = true, value = "select * from bondsdata where UPPER(trade_type) = UPPER('sell')")
    List<BondsData> getSells();
}