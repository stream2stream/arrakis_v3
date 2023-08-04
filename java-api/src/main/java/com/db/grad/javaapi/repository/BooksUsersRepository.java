package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BookUsers;
import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksUsersRepository extends JpaRepository<Books, String>
{
    @Query(nativeQuery = true, value = "select distinct b.bookname, bu.bondholder, b.status, b.issuername, b.isin, b.cusip, b.facevalue, b.bondmaturitydate, b.bondcurrency, b.couponpercent, b.unitprice\n" +
            "from booksusers bu left join books b \n" +
            "on bu.bookname = b.bookname where bondholder = :bondholder and status = 'active'")
    List<String> getAllBooksUser(String bondholder);
}