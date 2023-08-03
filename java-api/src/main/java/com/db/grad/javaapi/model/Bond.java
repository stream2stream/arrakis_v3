package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bond")
public class Bond {
    private enum currency_enum {
        USD, GBP
    }

    private enum status_enum{
        active, inactive
    }
    private enum type_enum{
        CORP, GOVN, SOVN
    }
    @Id
    @Column(name = "isin")
    private String isin;
    @Column(name = "cusip")
    private String cusip;
    @Column(name = "unit_price", nullable = false)
    private Float unit_price;

    @Column(name = "coupon_percent", nullable = false)
    private Float coupon_percent;
    @Enumerated(EnumType.STRING)
    @Column(name = "bond_currency", nullable = false)
    private currency_enum bond_currency;
    @Column(name = "issuer_name", nullable = false)
    private String issuer_name;

    @Column(name = "face_value", nullable = false)
    private int face_value;
    @Temporal(TemporalType.DATE)
    @Column(name = "bond_maturity_date", nullable = false)
    private Date bond_maturity_date;
    @Enumerated(EnumType.STRING)
    @Column(name = "bond_status", nullable = false)
    private status_enum bond_status;
    @Enumerated(EnumType.STRING)
    @Column(name = "bond_type", nullable = false)
    private type_enum bond_type;


    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {
        this.isin = isin;
    }


    public String getCusip() {
        return cusip;
    }
    public void setCusip(String cusip) {
        this.cusip = cusip;
    }


    public Float getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }

    public Float getCoupon_percent() {
        return coupon_percent;
    }

    public void setCoupon_percent(Float coupon_percent) {
        this.coupon_percent = coupon_percent;
    }

    public currency_enum getBond_currency() {
        return bond_currency;
    }
    public void setBond_currency(currency_enum bond_currency) {
        this.bond_currency = bond_currency;
    }


    public String getIssuer_name() {
        return issuer_name;
    }
    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    public int getFace_value() {
        return face_value;
    }

    public void setFace_value(int face_value) {
        this.face_value = face_value;
    }

    public Date getBond_maturity_date() {
        return bond_maturity_date;
    }
    public void setBond_maturity_date(Date bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
    }


    public status_enum getBond_status() {
        return bond_status;
    }
    public void setBond_status(status_enum bond_status) {
        this.bond_status = bond_status;
    }


    public type_enum getBond_type() {
        return bond_type;
    }
    public void setBond_type(type_enum bond_type) {
        this.bond_type = bond_type;
    }


    @Override
    public String toString() {
        return "Bond{" +
                "isin='" + isin + '\'' +
                ", cusip='" + cusip + '\'' +
                ", unit_price=" + unit_price +
                ", coupon_percent=" + coupon_percent +
                ", bond_currency=" + bond_currency +
                ", issuer_name='" + issuer_name + '\'' +
                ", face_value='" + face_value + '\'' +
                ", bond_maturity_date=" + bond_maturity_date +
                ", bond_status=" + bond_status +
                ", bond_type=" + bond_type +
//                ", bond_book_number='" + bond_book + '\'' +
                '}';
    }
}
