package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int book_id;
//    private int security_id;
    private int counterparty_id;
    private String currency;
    private String status;
    private int quantity;
    private double unit_price;
    private String buy_sell;
    private Date trade_date;
    private Date settlement_date;

    @Id
    @Column(name = "trade_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "book_id", nullable = false)
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

//    @Column(name = "security_id", nullable = false)
//    public int getSecurity_id() {
//        return security_id;
//    }
//
//    public void setSecurity_id(int security_id) {
//        this.security_id = security_id;
//    }

    @Column(name = "bond_holder_id", nullable = false)
    public int getCounterparty_id() {
        return counterparty_id;
    }

    public void setCounterparty_id(int counterparty_id) {
        this.counterparty_id = counterparty_id;
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
    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    @Column(name = "trade_type", nullable = false)
    public String getBuy_sell() {
        return buy_sell;
    }

    public void setBuy_sell(String buy_sell) {
        this.buy_sell = buy_sell;
    }

    @Column(name = "trade_date", nullable = false)
    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    @Column(name = "trade_settlement_date", nullable = false)
    public Date getSettlement_date() {
        return settlement_date;
    }

    public void setSettlement_date(Date settlement_date) {
        this.settlement_date = settlement_date;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", book_id=" + book_id +
//                ", security_id=" + security_id +
                ", counterparty_id=" + counterparty_id +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", buy_sell='" + buy_sell + '\'' +
                ", trade_date=" + trade_date +
                ", settlement_date=" + settlement_date +
                '}';
    }
}
