package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<BookUser> bookUsers;

}