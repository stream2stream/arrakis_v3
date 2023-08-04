package com.db.grad.javaapi.model;



import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "bond_details")
public class Bond
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String TRADE_CURRENCY;
    private long FACE_VALUE;
    private Date BOND_MATURITY_DATE;
    private String CUSIP;

    private String ISIN;

    @Id
    @Column(name = "Id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "TRADE_CURRENCY", nullable = false)
    public String getTRADE_CURRENCY() {
        return TRADE_CURRENCY;
    }
    public void setTRADE_CURRENCY(String TRADE_CURRENCY) {
        this.TRADE_CURRENCY = TRADE_CURRENCY;
    }

    @Column(name = "FACE_VALUE", nullable = false)
    public long getFACE_VALUE() {
        return FACE_VALUE;
    }
    public void setFACE_VALUE(long FACE_VALUE) {
        this.FACE_VALUE = FACE_VALUE;
    }

    @Column(name="BOND_MATURITY_DATE")
    public Date getBOND_MATURITY_DATE() {
        return BOND_MATURITY_DATE;
    }

    public void setBOND_MATURITY_DATE(Date BOND_MATURITY_DATE) {
        this.BOND_MATURITY_DATE = BOND_MATURITY_DATE;
    }

    @Column(name="CUSIP")
    public String getCUSIP() {
        return CUSIP;
    }

    public void setCUSIP(String CUSIP) {
        this.CUSIP = CUSIP;
    }

    @Column(name="ISIN")
    public String getISIN(String ISIN) {
        return this.ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }
}
