package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class security
{
    @Id
    private long id;
    private float couponPercent;
    private long faceValue;
    private String bondCurrency, cusip, isin, issuerName,
            BondMaturityDate, status, type;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "couponPercent", nullable = false)
    public float getCouponPercent() {
        return couponPercent;
    }
    public void setCouponPercent(float couponPercent) {
        this.couponPercent = couponPercent;
    }

    @Column(name = "faceValue", nullable = false)
    public long getFaceValue() {
        return faceValue;
    }
    public void setFaceValue(long faceValue) {
        this.faceValue = faceValue;
    }

    @Column(name = "bondCurrency", nullable = false)
    public String getBondCurrency() {
        return bondCurrency;
    }
    public void setBondCurrency(String bondCurrency) {
        this.bondCurrency = bondCurrency;
    }

    @Column(name = "cusip", nullable = false)
    public String getCusip() {
        return cusip;
    }
    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Column(name = "issuerName", nullable = false)
    public String getIssuerName() {
        return issuerName;
    }
    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    @Column(name = "bondMaturityDate", nullable = false)
    public String getBondMaturityDate() {
        return BondMaturityDate;
    }
    public void setBondMaturityDate(String bondMaturityDate) {
        BondMaturityDate = bondMaturityDate;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
