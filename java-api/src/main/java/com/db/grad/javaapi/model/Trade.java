package com.db.grad.javaapi.model;

import java.util.Date;
public class Trade {
    private int book_id;
    private int security_id;
    private int counterparty_id;
    private String currency;
    private int quantity;
    private double unit_price;
    private String buy_sell;
    private Date trade_date;
    private Date settlement_date;

    public Trade(int book_id, int security_id, int counterparty_id, String currency, int quantity, double unit_price, String buy_sell, Date trade_date, Date settlement_date){
        this.book_id = book_id;
        this.security_id = security_id;
        this.counterparty_id = counterparty_id;
        this.currency = currency;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.buy_sell = buy_sell;
        this.trade_date = trade_date;
        this.settlement_date = settlement_date;
    }


}
