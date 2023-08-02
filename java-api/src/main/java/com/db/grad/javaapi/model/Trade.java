package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Int id;
    private String tradeType;
    private String tradeCurrency;
    private Integer quantity;
    private LocalDate tradeSettlementDate;
    private String tradeStatus;
    private LocalDate tradeDate;
    private Double unitPrice;
    private String bondHolder;

    @ManyToOne
    @JoinColumn(name = "id")
    private Bond bond;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
