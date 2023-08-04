package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BondRepository extends JpaRepository<Bond, Integer> {

    Bond findByIsinAndCusip(String isin, String cusip);

    @Query(value = "SELECT * FROM bond WHERE id IN (SELECT bond_id FROM trade WHERE book_id = :bookId)", nativeQuery = true)
    List<Bond> findBondsByBookId(int bookId);


    @Query("SELECT b FROM Bond b WHERE b.bondMaturityDate BETWEEN :startDate AND :endDate")
    List<Bond> findBondsWithMaturityDateInFiveDays(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT b FROM Bond b WHERE b.bondMaturityDate BETWEEN :startDate AND :endDate")
    List<Bond> findBondsWithMaturityDateFiveDaysBefore(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}