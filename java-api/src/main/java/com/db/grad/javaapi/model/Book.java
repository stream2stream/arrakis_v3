package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book
{
    @Id
    private int book_id  ;
    private String book_name;

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Column(name = "book_name", nullable = false)
    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    @Override
    public String toString() {
        return "book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                '}';
    }
}
