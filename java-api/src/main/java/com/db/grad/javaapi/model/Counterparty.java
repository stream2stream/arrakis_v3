package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Counterparty")
public class Counterparty {
    @Id
    private int ID;
    private String Name;
    @Id
    @Column(name="bond_holder_id",nullable = false)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name="bond_holder")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "CounterParty{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
