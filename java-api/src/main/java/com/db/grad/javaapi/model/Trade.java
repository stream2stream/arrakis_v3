package com.db.grad.javaapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tradeType;
    private String tradeCurrency;
    private double quantity;
    private String tradeSettlementDate;
    private String tradeStatus;
    private String tradeDate;
    private double unitPrice;
    private double couponPercent;
    private String cusip;
    private String bookName;
    private String bondHolder;

}