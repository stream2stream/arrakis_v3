package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "counterparties")
public class Counterparty {
    @Id
    private int id;
    private String name;

    //~Handles sql JOIN logic
    //JOIN counterparty's id ON trade's counterparty_id
    @OneToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name="id", referencedColumnName="counterparty_id", insertable=false, updatable=false)
    private Trade trade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
