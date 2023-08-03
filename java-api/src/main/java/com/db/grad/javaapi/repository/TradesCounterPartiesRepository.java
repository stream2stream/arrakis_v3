package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.TradesCounterParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradesCounterPartiesRepository extends JpaRepository<TradesCounterParty, Integer> {
}
