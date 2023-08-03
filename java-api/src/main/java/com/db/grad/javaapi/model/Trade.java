package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade")
public class Trade {
    @Id
    private long id;
    @Column(name = "tradetype", nullable = false)
    private String tradeType;
    @Column(name = "tradecurrency", nullable = false)
    private String tradeCurrency;
    @Column(name = "quantity", nullable = false)
    private long quantity;
    @Column(name = "tradesettlementdate", nullable = false)
    private String tradeSettlementDate;
    @Column(name = "tradestatus", nullable = false)
    private String tradeStatus;
    @Column(name = "tradedate", nullable = false)
    private String tradeDate;
    @Column(name = "unitprice", nullable = false)
    private float unitPrice;
    @Column(name = "counterpartyid", nullable = false)
    private long counterPartyID;
    @Column(name = "securityid", nullable = false)
    private long securityID;
    @Column(name = "bookid", nullable = false)
    private long bookID;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getTradeSettlementDate() {
        return tradeSettlementDate;
    }

    public void setTradeSettlementDate(String tradeSettlementDate) {
        this.tradeSettlementDate = tradeSettlementDate;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getCounterPartyID() {
        return counterPartyID;
    }

    public void setCounterPartyID(long counterPartyID) {
        this.counterPartyID = counterPartyID;
    }

    public long getSecurityID() {
        return securityID;
    }

    public void setSecurityID(long securityID) {
        this.securityID = securityID;
    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }
}
