package com.db.grad.javaapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bondCurrencyCusip;
    private double faceValue;
    private String isin;
    private String issuerName;
    private String bondMaturityDate;
    private String statusType;

}