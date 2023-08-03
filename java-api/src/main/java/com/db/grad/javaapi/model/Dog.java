public class Trades {
    private int id;
    private int bookId;
    private int securityId;
    private int counterpartyId;
    private String currency;
    private String status;
    private int quantity;
    private float unitPrice;
    private String buySell;
    private Date tradeDate;
    private Date settlementDate;

    public Trades(int id, int bookId, int securityId, int counterpartyId, String currency, String status, int quantity, float unitPrice, String buySell, Date tradeDate, Date settlementDate) {
        this.id = id;
        this.bookId = bookId;
        this.securityId = securityId;
        this.counterpartyId = counterpartyId;
        this.currency = currency;
        this.status = status;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.buySell = buySell;
        this.tradeDate = tradeDate;
        this.settlementDate = settlementDate;
    }

    // getters and setters
}




package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dogs")
public class Dog
{
    @Id
    private long id;
    private String name;
    private long age;

    @Id
    @Column(name = "dog_id", nullable = false)
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

    @Column(name = "age", nullable = false)
    public long getAge() {
        return age;
    }
    public void setAge(long age) {
        this.age = age;
    }
}
