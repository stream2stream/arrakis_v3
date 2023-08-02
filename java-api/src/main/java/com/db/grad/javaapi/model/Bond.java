package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="bonds")
public class Bond {

    @Id
    private String isin;
    private String type;
    private String issuerName;
    private Date bondMaturityDate;
    private int faceValue;
    private String bondCurrency;
    private double couponPercent;
    private String status;
    private String cusip;

    @Id
    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Column(name = "type", nullable = false)

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "issuer_name", nullable = false)

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    @Column(name = "bond_maturity_date", nullable = false)

    public Date getBondMaturityDate() {
        return bondMaturityDate;
    }

    public void setBondMaturityDate(Date bondMaturityDate) {
        this.bondMaturityDate = bondMaturityDate;
    }

    @Column(name = "face_value", nullable = false)

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    @Column(name = "bond_currency", nullable = false)

    public String getBondCurrency() {
        return bondCurrency;
    }

    public void setBondCurrency(String bondCurrency) {
        this.bondCurrency = bondCurrency;
    }

    @Column(name = "coupon_percent", nullable = false)

    public double getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(double couponPercent) {
        this.couponPercent = couponPercent;
    }

    @Column(name = "status", nullable = false)

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "cusip", nullable = true)

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }
}
