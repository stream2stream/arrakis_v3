package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.grad.javaapi.model.Trade;

public interface TradesRepository extends JpaRepository<Trade, Integer> {
    // Intentionally blank
}
