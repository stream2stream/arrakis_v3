package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firebase_user_id", unique = true)
    private String firebaseUserId;

    @ElementCollection()
    @CollectionTable(name = "trading_books", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "books")
    private List<String> tradingBooks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirebaseUserId() {
        return firebaseUserId;
    }

    public void setFirebaseUserId(String userId) {
        this.firebaseUserId = userId;
    }

    public List<String> getTradingBooks() {
        return tradingBooks;
    }

    public void setTradingBooks(List<String> tradingBooks) {
        this.tradingBooks = tradingBooks;
    }
}
