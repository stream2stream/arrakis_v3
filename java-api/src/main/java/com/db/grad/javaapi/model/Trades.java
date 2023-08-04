package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "trades") //change DB to trades, now is a new db
public class Trades
{
    @Id
    private int tradeId;
    private String tradeCurrency;
    private String tradeType;
    private String tradeSettlementDate;
    private String tradeStatus;
    private String tradeDate;
    private int quantity;
    private String bookName;
    private String isin;

    @Id
    @Column(name = "tradeid", nullable = false)
    public int getTradeId() {return tradeId;}
    public void setTradeId(int id) {this.tradeId = tradeId;}

    @Column(name = "tradetype", nullable = false)
    public String getTradeType() {return tradeType;}
    public void setTradeType(String type) {this.tradeType = tradeType;}

    @Column(name = "bookname", nullable = false)
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}

    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Column(name = "tradecurrency", nullable = false)
    public String getTradeCurrency(){return tradeCurrency;}
    public void setTradeCurrency(String tradeCurrency){this.tradeCurrency = tradeCurrency;}

    @Column(name = "tradedate", nullable = false)
    public String getTradeDate() {return tradeDate;}
    public void setTradeDate(String tradeDate){this.tradeDate = tradeDate;}

    @Column(name = "tradestatus", nullable = false)
    public String getTradeStatus() {return this.tradeStatus;}
    public void setTradeStatus(String status) {this.tradeStatus = status;}

    @Column(name = "tradesettlementdate", nullable = false)
    public String getTradeSettlementDate() {return tradeSettlementDate;}
    public void setTradeSettlementDate(String tradeSettlementDate) {this.tradeSettlementDate = tradeSettlementDate;}


    @Column(name = "quantity", nullable = false) // Column bondHolder: "quantity"
    public int getQuantity(){return quantity;}
    public void setQuantity(int quantity){this.quantity = quantity;}


    }