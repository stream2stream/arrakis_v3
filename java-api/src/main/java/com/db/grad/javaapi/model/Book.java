package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;

    @OneToMany(mappedBy = "book")
    private List<Trade> trades;


    @ManyToMany
    @JoinTable(
            name = "book_user", // name of the join table
            joinColumns = @JoinColumn(name = "book_id"), // foreign key column for Book
            inverseJoinColumns = @JoinColumn(name = "user_id") // foreign key column for User
    )
    private List<User> users = new ArrayList<>();

    public int getId() {
        return id;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

//    public List<BookUser> getBookUsers() {
//        return bookUsers;
//    }
//
//    public void setBookUsers(List<BookUser> bookUsers) {
//        this.bookUsers = bookUsers;
//    }
}
