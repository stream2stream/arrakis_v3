package com.db.grad.javaapi.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "trades")
public class Trades {
    @Id
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

    /*public Trades(int id, int bookId, int securityId, int counterpartyId, String currency, String status, int quantity, float unitPrice, String buySell, Date tradeDate, Date settlementDate) {
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
    }*/

    // getters and setters

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    @Column(name = "security_id", nullable = false)
    public int getSecurityId() {
        return securityId;
    }
    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }

    @Column(name = "counterparty_id", nullable = false)
    public int getCounterpartyId() {
        return counterpartyId;
    }
    public void setCounterpartyId(int counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    @Column(name = "trade_currency", nullable = false)
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "trade_status", nullable = false)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "unit_price", nullable = false)
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "trade_type", nullable = false)
    public String getBuySell() {
        return buySell;
    }
    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    @Column(name = "trade_date", nullable = false)
    public Date getTradeDate() {
        return tradeDate;
    }
    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Column(name = "trade_settlement_date", nullable = false)
    public Date getSettlementDate() {
        return settlementDate;
    }
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }
}

/*
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
}*/
