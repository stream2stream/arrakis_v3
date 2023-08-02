package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogsRepository extends JpaRepository<Security, Long>
{
    @Query(nativeQuery = true, value = "select * from dogs where name = :name")
    List<Security> findByName(Security name);
}