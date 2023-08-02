package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double couponPercent;
    private String bondCurrency;
    private String cusip;
    private Double faceValue;
    private String isin;
    private String issuerName;
    private LocalDate bondMaturityDate;
    private String bondStatus;
    private String type;

    @OneToMany(mappedBy = "bond")
    private List<Trade> trades;

    public int getId() {
        return id;
    }


    public Double getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(Double couponPercent) {
        this.couponPercent = couponPercent;
    }

    public String getBondCurrency() {
        return bondCurrency;
    }

    public void setBondCurrency(String bondCurrency) {
        this.bondCurrency = bondCurrency;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public Double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Double faceValue) {
        this.faceValue = faceValue;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public LocalDate getBondMaturityDate() {
        return bondMaturityDate;
    }

    public void setBondMaturityDate(LocalDate bondMaturityDate) {
        this.bondMaturityDate = bondMaturityDate;
    }

    public String getBondStatus() {
        return bondStatus;
    }

    public void setBondStatus(String bondStatus) {
        this.bondStatus = bondStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }
}
