package com.db.grad.javaapi.repository;
import com.db.grad.javaapi.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>
{
    @Query(nativeQuery = true, value = "select * from books")
    List<Books> getAllBooks();


    //select bookid, bookname,status, bondmaturitydate, issuername, isin, facevalue, cusip, bondcurrency, couponpercent, unitprice, DAY_OF_WEEK(CAST(PARSEDATETIME( BONDMATURITYDATE,'dd-MM-yy') as DATE) ) from books where  CAST(PARSEDATETIME( BONDMATURITYDATE,'dd-MM-yy') as DATE)  between  CAST('2021-08-09' as DATE)-7  and CAST('2021-08-09' as DATE) +7 and status = 'active';
    @Query(nativeQuery = true, value = "select * from books where  CAST(PARSEDATETIME(BONDMATURITYDATE,'dd-MM-yy') as DATE)  between  CAST(:date as DATE)-7  and CAST(:date as DATE) +7 and status = 'active'")
    List<String> getBondsPlusMin(String date);


    @Query(nativeQuery = true, value = "select BONDMATURITYDATE from books")
    List<String> getMatDate();




}