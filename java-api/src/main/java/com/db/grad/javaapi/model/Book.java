package com.db.grad.javaapi.model;

import javax.persistence.*;


@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "bookname", nullable = false)
    private String bookName;
    public long getID() {
        return id;
    }
    public void setID(long id) {
        this.id = id;
    }

    public String getbookName() {
        return bookName;
    }
    public void setbookName(String bookName) {
        this.bookName = bookName;
    }

}
