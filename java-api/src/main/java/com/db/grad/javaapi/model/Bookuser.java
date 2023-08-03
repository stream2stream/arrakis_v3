package com.db.grad.javaapi.model;
import javax.persistence.*;


public class Bookuser {
    @ManyToMany
    @JoinTable(name= "book", joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"))
    private int book_id;
    @ManyToMany
    @JoinTable(name= "user", joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"))
    private int user_id;

    @Column(name= "book_id", nullable = false)
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Column(name= "user_id", nullable = false)
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}


