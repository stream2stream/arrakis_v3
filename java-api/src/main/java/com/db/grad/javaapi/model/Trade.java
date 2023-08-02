package com.db.grad.javaapi.model;

import java.time.LocalDateTime;
import java.util.Currency;

public class Trade{
  
    /*create private propertie for trade type */
    private String TradeType;
    
    /*create private propertie for trade currency*/
    private Currency TradeCurrency;

    /*create private propertie for id*/
    private String Iden;

    
    

    public Trade(String iden) {
        Iden = iden;
    }

   

    /*create private propertie for Quantity*/
    private int quantity;
    
    /*create private propertie for trade Status */
    private String TradeStatus;
    
    /*create private propertie for trade date */
    private LocalDateTime TradeDate;

    /*create private propertie for price*/
    private double UnitPrice;


    /*constructor for Trade*/
    public Trade(String tradeType, Currency tradeCurrency, int quantity, String tradeStatus, LocalDateTime tradeDate,
            double unitPrice, String Iden) {
        this.TradeType = tradeType;
        this.TradeCurrency = tradeCurrency;
        this.quantity = quantity;
        this.TradeStatus = tradeStatus;
        this.TradeDate = tradeDate;
        this.UnitPrice = unitPrice;
        this.Iden=Iden;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTradeStatus() {
        return TradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        TradeStatus = tradeStatus;
    }

    public LocalDateTime getTradeDate() {
        return TradeDate;
    }

    public void setTradeDate(LocalDateTime tradeDate) {
        TradeDate = tradeDate;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getTradeType() {
        return TradeType;
    }

    public void setTradeType(String tradeType) {
        TradeType = tradeType;
    }

    public Currency getTradeCurrency() {
        return TradeCurrency;
    }

    public void setTradeCurrency(Currency tradeCurrency) {
        TradeCurrency = tradeCurrency;
    }

     public String getIden() {
        return Iden;
    }

    public void setIden(String iden) {
        Iden = iden;
    }
    
    
}