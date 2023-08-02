package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bondsdata")
public class BondsData
{
    @Id
    @Column(name = "id")
    private int id;
    private String tradeType;
    private String tradeCurrency;
    private Integer quantity;
    private Date tradeSettlementDate;
    private String tradeStatus;
    private Date tradeDate;
    private Double unitPrice;
    private Double couponPercent;
    private String bondCurrency;
    private String cusip;
    private Integer faceValue;
    private String isin;
    private String issuerName;
    private Date bondMaturityDate;
    private String status;
    private String type;
    private String bookName;
    private String bondHolder;

    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int bondID) {
        this.id = bondID;
    }

    @Column(name = "trade_type")
    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    @Column(name = "trade_currency")
    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "trade_settlement_date")
    public Date getTradeSettlementDate() {
        return tradeSettlementDate;
    }

    public void setTradeSettlementDate(Date tradeSettlementDate) {
        this.tradeSettlementDate = tradeSettlementDate;
    }

    @Column(name = "trade_status")
    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    @Column(name = "trade_date")
    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Column(name = "unit_price")
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "coupon_percent")
    public Double getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(Double couponPercent) {
        this.couponPercent = couponPercent;
    }

    @Column(name = "bond_currency")
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

    @Column(name = "face_value")
    public Integer getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Integer faceValue) {
        this.faceValue = faceValue;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Column(name = "issuer_name")
    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    @Column(name = "bond_maturity_date")
    public Date getBondMaturityDate() {
        return bondMaturityDate;
    }

    public void setBondMaturityDate(Date bondMaturityDate) {
        this.bondMaturityDate = bondMaturityDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookName() {
        return bookName;
    }

    @Column(name = "book_name")
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column(name = "bond_holder")
    public String getBondHolder() {
        return bondHolder;
    }

    public void setBondHolder(String bondHolder) {
        this.bondHolder = bondHolder;
    }
}
