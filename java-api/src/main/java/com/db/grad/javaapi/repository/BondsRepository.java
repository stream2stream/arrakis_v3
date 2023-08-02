package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BondsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface BondsRepository extends JpaRepository<BondsData, Integer>
{
    // UPPER ==> Case insensitive queries
    @Query(nativeQuery = true, value = "select * from bondsdata where UPPER(bond_holder) = UPPER(:tradeType)")
    List<BondsData> findByHolderName(@Param("tradeType") String tradeType);

    @Query(nativeQuery = true, value = "select * from bondsdata where UPPER(type) = UPPER(:type)")
    List<BondsData> findByType(@Param("type") String type);

    @Query(nativeQuery = true, value = "select * from bondsdata where bond_maturity_date = :date")
    List<BondsData> findByMaturityDate(@Param("date") @Temporal(TemporalType.DATE) Date date);

    @Query(nativeQuery = true, value = "select * from bondsdata where UPPER(trade_type) = UPPER('buy')")
    List<BondsData> getBuys();

    @Query(nativeQuery = true, value = "select * from bondsdata where UPPER(trade_type) = UPPER('sell')")
    List<BondsData> getSells();
}