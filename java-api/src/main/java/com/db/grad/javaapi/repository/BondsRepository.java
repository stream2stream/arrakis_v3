package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BondsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BondsRepository extends JpaRepository<BondsData, Integer>
{
    @Query(nativeQuery = true, value = "select * from bondsData where trade_type = :tradeType")
    List<BondsData> findByName(String tradeType);
}