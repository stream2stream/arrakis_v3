package com.db.grad.javaapi.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "trades")
public class Trade {

    @Id
    private long id;
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

    @Column(name = "book_id", nullable = false)
    public int getTradeBookId(){
        return book_id;
    }
    @Column(name = "security_id", nullable = false)
    public int getTradeSecurityId(){
        return security_id;
    }
    @Column(name = "counterparty_id", nullable = false)
    public int getTradeCounterpartyId(){
        return counterparty_id;
    }
    @Column(name = "currency", nullable = false)
    public String getTradeCurrency(){
        return currency;
    }
    @Column(name = "quantity", nullable = false)
    public int getTradeQuantity(){
        return quantity;
    }
    @Column(name = "unit_price", nullable = false)
    public double getTradeUnitPrice(){
        return unit_price;
    }
    @Column(name = "buy_sell", nullable = false)
    public String getTradeBuySell(){
        return buy_sell;
    }
    @Column(name = "trade_date", nullable = false)
    public Date getTradeTradeDate(){
        return trade_date;
    }
    @Column(name = "settlement_date", nullable = false)
    public Date getTradeSettlementDate(){
        return settlement_date;
    }


}
