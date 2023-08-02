package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogsRepository extends JpaRepository<security, Long>
{
    @Query(nativeQuery = true, value = "select * from dogs where name = :name")
    List<security> findByName(security name);
}