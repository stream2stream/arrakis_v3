package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BondWithClient;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="bondsWithClients")
public interface BondsWithClientsRepository extends ReadOnlyRepository<BondWithClient, Long>{
    //Views need custom query
    @Query(nativeQuery = true, value = "select * from bondsWithClients")
    List<BondWithClient> findAll();
}
