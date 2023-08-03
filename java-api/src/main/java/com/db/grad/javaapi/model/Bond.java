package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Date;

@Entity
@Table(name = "bond")
public class Bond {
    private enum currency_enum {
        USD, GBP
    }

    private enum status_enum{
        ACTIVE, INACTIVE
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
    @Column(name = "bond_currency", nullable = false)
    private currency_enum bond_currency;
    @Column(name = "issuer_name", nullable = false)
    private String issuer_name;
    @Column(name = "bond_maturity_date", nullable = false)
    private Date bond_maturity_date;
    @Column(name = "bond_status", nullable = false)
    private status_enum bond_status;
    @Column(name = "bond_type", nullable = false)
    private type_enum bond_type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bond_book_number", referencedColumnName = "book_number")
    private Books bond_book;


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


    public Books getBond_book() {
        return this.bond_book;
    }
    public void setBond_book(Books bond_book) {
        this.bond_book = bond_book;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "isin='" + isin + '\'' +
                ", cusip='" + cusip + '\'' +
                ", unit_price=" + unit_price +
                ", bond_currency=" + bond_currency +
                ", issuer_name='" + issuer_name + '\'' +
                ", bond_maturity_date=" + bond_maturity_date +
                ", bond_status=" + bond_status +
                ", bond_type=" + bond_type +
                ", bond_book_number='" + bond_book + '\'' +
                '}';
    }
}
