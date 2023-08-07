package com.db.grad.javaapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Books
{
    @Id
    private int bookId;
    private String bookName;
    private String status;
    private String bondmaturitydate;
//    private LocalDate bondmaturitydate;
    private String issuername;
    private String isin;
    private int facevalue;
    private String cusip;
    private String bondcurrency;
    private double couponpercent;
    private double unitprice;

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

//    public void setBondMaturityDate(LocalDate bondmaturitydate){this.bondmaturitydate = bondmaturitydate;}
//    public LocalDate getBondMaturityDate(){return bondmaturitydate;}
    public String getBondmaturitydate() {return bondmaturitydate;}
    public void setBondmaturitydate(String bondmaturitydate) {this.bondmaturitydate = bondmaturitydate;}

    @Column(name = "issuername", nullable = false)
    public String getIssuerName() {return issuername;}
    public void setIssuerName(String issuerName) {this.issuername = issuerName;}

    @Column(name = "isin", nullable = false)
    public String getIsin() {return isin;}
    public void setIsin(String isin) {this.isin = isin;}

    @Column(name = "facevalue", nullable = false)
    public int getFaceValue() {return facevalue;}
    public void setFaceValue(int faceValue) {this.facevalue = faceValue;}

    @Column(name = "cusip", nullable = false)
    public String getCusip() {return cusip;}
    public void setCusip(String cusip) {this.cusip = cusip;}

    @Column(name = "bondcurrency", nullable = false)
    public String getBondCurrency() {return bondcurrency;}
    public void setBondCurrency(String bondCurrency) {this.bondcurrency = bondCurrency;}

    @Column(name = "couponpercent", nullable = false)
    public double getCouponPercent() {return couponpercent;}
    public void setCouponPercent(double couponPercent) {this.couponpercent = couponPercent;}

    @Column(name = "unitprice", nullable = false)
    public double getUnitPrice() {return unitprice;}
    public void setUnitPrice(double unitPrice) {this.unitprice = unitPrice;}
}
