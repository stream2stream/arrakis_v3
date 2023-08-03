package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name="counter_party")
public class CounterParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bondholder", nullable = false)
    private String bondHolder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBondHolder() {
        return bondHolder;
    }

    public void setBondHolder(String bondHolder) {
        this.bondHolder = bondHolder;
    }
}
