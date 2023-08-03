package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BondsCounterParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BondsCounterPartiesRepository extends JpaRepository<BondsCounterParty, Integer> {
}
