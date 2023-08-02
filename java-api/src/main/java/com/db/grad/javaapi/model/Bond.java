package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Int id;
    private Double couponPercent;
    private String bondCurrency;
    private String cusip;
    private Double faceValue;
    private String isin;
    private String issuerName;
    private LocalDate bondMaturityDate;
    private String bondStatus;
    private String type;

    @OneToMany(mappedBy = "bond")
    private List<Trade> trades;


}
