package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;

    @OneToMany(mappedBy = "book")
    private List<Trade> trades;

    @OneToMany(mappedBy = "book")
    private List<BookUser> bookUsers;

    // getters and setters
}