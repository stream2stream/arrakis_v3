package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Credentials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CredentialsRepository extends CrudRepository<Credentials,Long> {
    @Query(nativeQuery = true, value = "select c from credentials where c.email =: email")
    public Credentials getCredentialsByEmail(@Param("email") String email);


}
