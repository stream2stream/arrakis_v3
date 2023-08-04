package com.db.grad.javaapi.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Immutable@Table(name="bondsWithClients")
public class BondWithClient {
    //~Handles sql JOIN logic
    //JOIN trade's bond_id ON bond's isin
    //JOIN trade's counterparty_id ON counterparty's id

    //Bond fields
    @Id
    @Column(insertable = false, updatable = false)
    private String isin;
    private int faceValue;
    private float couponPercent;
    private String cusip;
    private String bondCurrency;
    private String bondMaturity;
    private String issuerName;
    private String status;
    private String type;

    //Trade fields
    private int clientId;
    private String clientName;

    public String getIsin() {
        return isin;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public float getCouponPercent() {
        return couponPercent;
    }

    public String getCusip() {
        return cusip;
    }

    public String getBondCurrency() {
        return bondCurrency;
    }

    public String getBondMaturity() {
        return bondMaturity;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }
}
