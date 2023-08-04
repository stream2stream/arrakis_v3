package com.db.grad.javaapi.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class BondDTO {
    private String isin;
    private String cusip;
    private String issuerName;
    private LocalDateTime maturityDate;
    private float coupon;
    private String type;
    private float faceValue;
    private String currency;
    private String status;

    public BondDTO(String isin, String cusip, String issuerName, LocalDateTime maturityDate, float coupon, String type, float faceValue, String currency, String status) {
        this.isin = isin;
        this.cusip = cusip;
        this.issuerName = issuerName;
        this.maturityDate = maturityDate;
        this.coupon = coupon;
        this.type = type;
        this.faceValue = faceValue;
        this.currency = currency;
        this.status = status;
    }

    public BondDTO() {
    }

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

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(float faceValue) {
        this.faceValue = faceValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BondDTO{" +
                "isin='" + isin + '\'' +
                ", cusip='" + cusip + '\'' +
                ", issuerName='" + issuerName + '\'' +
                ", maturityDate=" + maturityDate +
                ", coupon=" + coupon +
                ", type='" + type + '\'' +
                ", faceValue=" + faceValue +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
