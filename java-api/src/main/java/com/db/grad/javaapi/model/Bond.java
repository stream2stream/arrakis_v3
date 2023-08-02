package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bonds")
public class Bond
{
    @Id
    private long id;
    private String trade_type;
    private String trade_currency;
    private int quantity;
    private Date trade_settlement_date;
    private boolean trade_status;
    private Date trade_date;
    private double unit_price;
    private double coupon_percent;
    private String bond_currency;
    private String cusip;
    private int face_value;
    private String isin;
    private String issuer_name;
    private Date bond_maturity_date;
    private String status;
    private String type;
    private String book_name;
    private String bond_holder;

    @Id
    @Column(name = "bond_id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTrade_currency() {
        return trade_currency;
    }

    public void setTrade_currency(String trade_currency) {
        this.trade_currency = trade_currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTrade_settlement_date() {
        return trade_settlement_date;
    }

    public void setTrade_settlement_date(Date trade_settlement_date) {
        this.trade_settlement_date = trade_settlement_date;
    }

    public boolean isTrade_status() {
        return trade_status;
    }

    public void setTrade_status(boolean trade_status) {
        this.trade_status = trade_status;
    }

    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getCoupon_percent() {
        return coupon_percent;
    }

    public void setCoupon_percent(double coupon_percent) {
        this.coupon_percent = coupon_percent;
    }

    public String getBond_currency() {
        return bond_currency;
    }

    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public int getFace_value() {
        return face_value;
    }

    public void setFace_value(int face_value) {
        this.face_value = face_value;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIssuer_name() {
        return issuer_name;
    }

    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    public Date getBond_maturity_date() {
        return bond_maturity_date;
    }

    public void setBond_maturity_date(Date bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBond_holder() {
        return bond_holder;
    }

    public void setBond_holder(String bond_holder) {
        this.bond_holder = bond_holder;
    }
}
