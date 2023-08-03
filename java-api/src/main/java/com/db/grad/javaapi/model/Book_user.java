package com.db.grad.javaapi.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="Trade")

public class Book_user {
    private int User_id;
    private int Book_id;
    public Book_user(int book_user, int book_id) {
        this.User_id = book_user;
        this.Book_id = book_id;
    }

    @Id
    @Column(name="", nullable=false)
    public int getbook_id() {
        return Book_id;
    }
    public void setBook_id(int book_id) {
        Book_id = book_id;
    }
    public int getuser_id() {
        return User_id;
    }
    public void setUser_id(int user_id) {
        User_id = user_id;
    }
    
}
