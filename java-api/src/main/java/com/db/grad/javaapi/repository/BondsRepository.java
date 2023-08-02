package com.db.grad.javaapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.db.grad.javaapi.model.Security;
import java.util.List;

@Repository
public interface BondsRepository extends JpaRepository<Security, Long>
{
    // Find a bond based on ISIN number, which is unique to a bond
    @Query(nativeQuery = true, value = "select * from security where isin = :isin")
    List<Security> findSecurityByIsin(String isin);

    
}
