package com.db.grad.javaapi.Test;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.service.SecurityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestEntityManager
class SecurityServiceTest {
   @Autowired
   private SecurityService securityService;
   @Autowired
   private SecurityRepository securityRepository;
   @PersistenceContext
   private EntityManager entityManager;


   @BeforeEach
    void setUp() {
       Security security1 = new Security(1,"USN0280EAR64","123456780","Airbus 3.15% USD", LocalDateTime.of(2021,7,30,0,0,0),3,"CORP",900,"USD","active");
       Security security2 = new Security(2,"USU02320AG12","123456780","Amazon", LocalDateTime.of(2021,8,3,0,0,0),3,"CORP",60,"USD","active");
       entityManager.persist(security1);
       entityManager.persist(security2);
       entityManager.flush();
//       securityRepository.saveAll(List.of(security1,security2));
       securityService = new SecurityService(securityRepository);
    }

    @Test
    @DisplayName("Get Securities")
    void getAllSecuritiesForUserBooks() {
       List<Security> testObject = securityService.getAllSecuritiesForUserBooks("user1@db.com");
       assertEquals(1, testObject.size());
    }
}