package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BondsRepository extends JpaRepository<Bond, String>  {
    @Query(nativeQuery = true, value = "select * from bonds where isin = :isin")
    List<Bond> findByISIN(String isin);

    @Query(nativeQuery = true, value = "select * from bonds where abs(datediff(day, parsedatetime(current_date, 'DD/MM/yyyy'))) <= 7")
    List<Bond> findByMaturity();

    //Consider natural join?
    public final String bondsWithClientInfo = "SELECT b.isin, b.cusip, b.bond_currency, b.face_value, b.bond_maturity, b.coupon_percent, b.issuer_name, b.status, b.type, c.id as clientId, c.name as clientName" + " " +
                                               "FROM bonds as b " + " " +
                                               "JOIN trades as t ON b.isin = t.bond_id" + " " +
                                               "JOIN counterparties as c ON t.counterpary_id = c.id" + " " +
                                               "WHERE True";
    @Query(nativeQuery = true, value = bondsWithClientInfo)
    List<Bond> findBondsWithCounterparty();

}

