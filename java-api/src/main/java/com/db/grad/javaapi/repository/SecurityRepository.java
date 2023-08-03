package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer> {
    @Query(nativeQuery = true, value = "SELECT DISTINCT s.*" + "FROM Security s " + "INNER JOIN Book b ON s.book_id = b.id" + "WHERE b.id IN" + "(SELECT bu.book_id FROM book_users bu WHERE bu.user_id = :userId)")
    List<Security> findSecuritiesForUserBooks(@Param("userId") Long userId);
}
