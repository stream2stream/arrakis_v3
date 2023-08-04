package com.db.grad.javaapi.repository;

//import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<Security,Integer> {

    /* mvp 1.0 story 1
        In order to view the portfolio as a user I want to see all the bonds active in the system
     */
    @Query(nativeQuery = true, value = "select * from Security where Status = 'active'")
    List<Security> findActiveBonds();

    /*  mvp 1.0 story 2
        In order to provide optics on positions,
        as a user I want to be able to view Bonds due for maturity within the last and next 5 days
     */
    @Query(nativeQuery = true, value = "SELECT * FROM SECURITY WHERE MATURITY_DATE BETWEEN DATEADD('DAY', -5, :user_date) AND DATEADD('DAY', 5, :user_date);")
    List<Security> find5DaysBonds(LocalDateTime user_date);


    // mvp 1.0 story 3


    /* mvp 1.0 story 5
        In order to identify the issuer of the bond, as a user I want to be able to see the issuer of the bond
     */
    @Query(nativeQuery = true, value = "SELECT DISTINCT ISSUER_NAME FROM SECURITY WHERE CUSIP = :cusip;")
    List<Security> identifyIssuer(String cusip);

    /* mvp 1.0 story 8
        In order to understand the security, as a user I want to be able to see the details of individual bonds
     */
    @Query(nativeQuery = true, value = "SELECT * FROM Security WHERE issuer_name = :issuer;")
    List<Security> bondDetails(String issuer);


}
