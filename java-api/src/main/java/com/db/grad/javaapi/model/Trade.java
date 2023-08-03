package com.db.grad.javaapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//Refers to only date (and not time)
import java.sql.Date;

@Entity
@Table(name = "trades")
public class Trade {
    @Id
    private int id;
    private int book_id, bond_id, counterparty_id, quantity;
    private String currency, status, buy_sell;
    private float unit_price;

//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date, settlement_date;

    //    TODO: How to handle foreign key?
//    private int FK_security_id;
//    private int FK_counterparty_id;
//    private int FK_book_id;
}
