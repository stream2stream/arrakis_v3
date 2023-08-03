package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "counterparty")
public class Counterparty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Counterparty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
