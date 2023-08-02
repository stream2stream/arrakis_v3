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
    private long bondID;
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

    @Id
    @Column(name = "dog_id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age", nullable = false)
    public long getAge() {
        return age;
    }
    public void setAge(long age) {
        this.age = age;
    }
}
