package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * We will use this class to keep track of trades present in a book
 */
@Entity
@Table(name = "book")
public class Book {
    // Id of the book
    @Id
    private int bookId;
    // Name of the book
    private String bookName;

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Column(name = "book_name", nullable = false)
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}
