package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.stereotype.Repository;

@Repository
public interface TradesRepository extends JpaRepository<Trade, Integer> {
    // Intentionally blank
}
