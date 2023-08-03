package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Trade> tradesList;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookUser> bookUserList;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
