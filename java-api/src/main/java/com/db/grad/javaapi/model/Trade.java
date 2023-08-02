package com.db.grad.javaapi.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trades")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long book_id;
    private long security_id;
    private long counterparty_id;
    private String currency;
    private String status;
    private int quantity;
    private float unit_price;
    private String buy_sell;
    private Date trade_date;
    private Date settlement_date;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @Column(name = "book_id", nullable = false)
    public long getBook_id() {
        return book_id;
    }


    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    @Id
    @Column(name = "security_id", nullable = false)
    public long getSecurity_id() {
        return security_id;
    }

    public void setSecurity_id(long security_id) {
        this.security_id = security_id;
    }

    @Id
    @Column(name = "counterparty_id", nullable = false)
    public long getCounterparty_id() {
        return counterparty_id;
    }

    public void setCounterparty_id(long counterparty_id) {
        this.counterparty_id = counterparty_id;
    }

    @Id
    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Id
    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Id
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Id
    @Column(name = "unit_price", nullable = false)
    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    @Id
    @Column(name = "buy_sell", nullable = false)
    public String getBuy_sell() {
        return buy_sell;
    }

    public void setBuy_sell(String buy_sell) {
        this.buy_sell = buy_sell;
    }

    @Id
    @Column(name = "trade_date", nullable = false)
    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    @Id
    @Column(name = "settlement_date", nullable = false)
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
                ", security_id=" + security_id +
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
