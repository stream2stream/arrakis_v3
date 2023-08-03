package com.db.grad.javaapi.service;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book_user")
public class Book_User {
    private int book_id;
    private int user_id;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
