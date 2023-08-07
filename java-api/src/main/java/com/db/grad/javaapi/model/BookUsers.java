package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "booksusers")
public class BookUsers {
    @Id
    private int bookUserId;
    private int userid;
    private int bookid;

    @Column(name = "bookuserid", nullable = false)
    public int getBookUserId() {return bookUserId;}
    public void setBookUserId(int bookUserId) {this.bookUserId = bookUserId;}

    @Column(name = "userid", nullable = false)
    public int getBondHolder() {return userid;}
    public void setBondHolder(int bondHolder) {this.userid = userid;}

    @Column(name = "bookid", nullable = false)
    public int getBookName() {return bookid;}
    public void setBookName(int bookName) {this.bookid = bookid;}

}
