package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "books")
public class Books
{
    @Id
    private int bookId;
    private String bookName;
    private String status;
    private String bondMaturityDate;
    private String issuerName;
    private String isin;
    private int faceValue;
    private String cusip;
    private String bondCurrency;
    private double couponPercent;
    private double unitPrice;

    @Id
    @Column(name = "bookid", nullable = false)
    public int getId() {
        return bookId;
    }
    public void setId(int id) {
        this.bookId = id;
    }

    @Column(name = "bookname", nullable = false)
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "bondmaturitydate", nullable = false)
    public String setBondMaturityDate(){return bondMaturityDate;}
    public void getBondMaturityDate(String bondMaturityDate){ this.bondMaturityDate = bondMaturityDate;}
    @Column(name = "issuername", nullable = false)
    public String getIssuerName() {return issuerName;}
    public void setIssuerName(String issuerName) {this.issuerName = issuerName;}

    @Column(name = "isin", nullable = false)
    public String getIsin() {return isin;}
    public void setIsin(String isin) {this.isin = isin;}

    @Column(name = "facevalue", nullable = false)
    public int getFaceValue() {return faceValue;}
    public void setFaceValue(int faceValue) {this.faceValue = faceValue;}

    @Column(name = "cusip", nullable = false)
    public String getCusip() {return cusip;}
    public void setCusip(String cusip) {this.cusip = cusip;}

    @Column(name = "bondcurrency", nullable = false)
    public String getBondCurrency() {return bondCurrency;}
    public void setBondCurrency(String bondCurrency) {this.bondCurrency = bondCurrency;}

    @Column(name = "couponpercent", nullable = false)
    public double getCouponPercent() {return couponPercent;}

    public void setCouponPercent(double couponPercent) {this.couponPercent = couponPercent;}

    @Column(name = "unitprice", nullable = false)
    public double getUnitPrice() {return unitPrice;}
    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}
}
