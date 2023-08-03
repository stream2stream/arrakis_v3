package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "security")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String isin;
    private String cusin;
    private String issuer_name ;
    private Date maturity_date;
    private int coupon;
    private String type;
    private int face_value;
    private String currency;
    private String status;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {
        this.isin = isin;
    }
    @Column(name = "cusin", nullable = false)
    public String getCusin() {
        return cusin;
    }

    public void setCusin(String cusin) {
        this.cusin = cusin;
    }
    @Column(name = "issuer_name", nullable = false)
    public String getIssuer_name() {
        return issuer_name;
    }

    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    @Column(name = "maturity_date", nullable = false)
    public Date getMaturity_date() {
        return maturity_date;
    }

    public void setMaturity_date(Date maturity_date) {
        this.maturity_date = maturity_date;
    }

    @Column(name = "coupon", nullable = false)
    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "face_value", nullable = false)
    public int getFace_value() {
        return face_value;
    }

    public void setFace_value(int face_value) {
        this.face_value = face_value;
    }

    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", isin=" + isin +
                ", cusin=" + cusin +
                ", issuer_name='" + issuer_name + '\'' +
                ", maturity_date=" + maturity_date +
                ", coupon=" + coupon +
                ", type='" + type + '\'' +
                ", face_value=" + face_value +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}