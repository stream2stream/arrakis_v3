package com.db.grad.javaapi.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Security {
    @Id
    private String isin;
    private String bond_currency;
    private String cusip;
    private double face_value_mn;
    private String issuer_name;
    private Date bond_maturity_date;
    private String s_status;
    private String s_type;
    private double coupon_percent;
    
    @Id
    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Column(name = "bond_currency", nullable = false)
    public String getBond_currency() {
        return bond_currency;
    }
    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }

    @Column(name = "cusip", nullable = true)
    public String getCusip() {
        return cusip;
    }
    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    @Column(name = "face_value_mn", nullable = false)
    public double getFace_value_mn() {
        return face_value_mn;
    }
    public void setFace_value_mn(double face_value_mn) {
        this.face_value_mn = face_value_mn;
    }

    @Column(name = "issuer_name", nullable = false)
    public String getIssuer_name() {
        return issuer_name;
    }
    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }


    @Column(name = "bond_maturity_date", nullable = false)
    public Date getBond_maturity_date() {
        return bond_maturity_date;
    }
    public void setBond_maturity_date(Date bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
    }

    @Column(name = "s_status", nullable = false)
    public String getS_status() {
        return s_status;
    }
    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    @Column(name = "s_type", nullable = false)
    public String getS_type() {
        return s_type;
    }
    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    @Column(name = "coupon_percent", nullable = false)
    public double getCoupon_percent() {
        return coupon_percent;
    }
    public void setCoupon_percent(double coupon_percent) {
        this.coupon_percent = coupon_percent;
    }
}