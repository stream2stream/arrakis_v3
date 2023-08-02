package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "counter_party")
public class CounterParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "counterParty", cascade = CascadeType.ALL)
    private List<Trade> tradesList;

    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
