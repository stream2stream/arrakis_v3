package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "users") // "users" refers to the "users" field in the Book entity
    private List<Book> books = new ArrayList<>();

    public int getId() {
        return id;
    }

//    public List<BookUser> getBookUsers() {
//        return bookUsers;
//    }
//
//    public void setBookUsers(List<BookUser> bookUsers) {
//        this.bookUsers = bookUsers;
//    }
}
