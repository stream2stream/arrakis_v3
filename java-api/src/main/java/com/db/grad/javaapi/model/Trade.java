package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int book_id;
    private int security_id;
    private int counter_party_id;
    private String currency;
    private int quantity;
    private float unit_price;
    private String buy_sell;
    private java.sql.Date trade_date;
    private java.sql.Date settlement_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getSecurity_id() {
        return security_id;
    }

    public void setSecurity_id(int security_id) {
        this.security_id = security_id;
    }

    public int getCounter_party_id() {
        return counter_party_id;
    }

    public void setCounter_party_id(int counter_party_id) {
        this.counter_party_id = counter_party_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getBuy_sell() {
        return buy_sell;
    }

    public void setBuy_sell(String buy_sell) {
        this.buy_sell = buy_sell;
    }

    public java.sql.Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(java.sql.Date trade_date) {
        this.trade_date = trade_date;
    }

    public java.sql.Date getSettlement_date() {
        return settlement_date;
    }

    public void setSettlement_date(java.sql.Date settlement_date) {
        this.settlement_date = settlement_date;
    }

}
