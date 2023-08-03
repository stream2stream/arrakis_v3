package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "book_user")
public class BookUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "bookid")
    private long bookID;
    @Column(name = "userid")
    private long userID;

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
