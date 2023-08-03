package com.db.grad.javaapi.model;

import javax.persistence.*;

//TO DO: NO GETTERS AND SETTERS (OR ANY FORM OF ANNOTATION) FOR THE ENUMS YET!

@Entity
@Table(name = "trade")
public class Trade {
    private enum trade_type_enum {
        sell, buy
    }
    private enum trade_currency_enum {
        USD, GBP
    }
    private enum trade_status_enum {
        open, closed
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id")
    private int trade_id;
    @Enumerated(EnumType.STRING)
    @Column(name = "trade_type", nullable = false)
    private trade_type_enum trade_type;
    @Enumerated(EnumType.STRING)
    @Column(name = "trade_currency", nullable = false)
    private trade_currency_enum trade_currency;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "trade_settlement_date", nullable = false)
    private String trade_settlement_date;
    @Enumerated(EnumType.STRING)
    @Column(name = "trade_status", nullable = false)
    private trade_status_enum trade_status;
    @Column(name = "trade_date", nullable = false)
    private String trade_date;

    @ManyToOne
    @JoinColumn(name = "bond_holder", nullable = false)
    private BondHolder bond_holder; //foreign key

    @ManyToOne
    @JoinColumn(name = "bond_reference", nullable = false)
    private Bond bond_reference; //foreign key

    @ManyToOne
    @JoinColumn(name = "book_reference", nullable = false)
    private Books book_reference;



    //------------getters and setters----------
    public int getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(int trade_id) {
        this.trade_id = trade_id;
    }

    public trade_type_enum getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(trade_type_enum trade_type) {
        this.trade_type = trade_type;
    }

    public trade_currency_enum getTrade_currency() {
        return trade_currency;
    }

    public void setTrade_currency(trade_currency_enum trade_currency) {
        this.trade_currency = trade_currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTrade_settlement_date() {
        return trade_settlement_date;
    }

    public void setTrade_settlement_date(String trade_settlement_date) {
        this.trade_settlement_date = trade_settlement_date;
    }

    public trade_status_enum getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(trade_status_enum trade_status) {
        this.trade_status = trade_status;
    }

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public BondHolder getBond_holder() {
        return bond_holder;
    }

    public void setBond_holder(BondHolder bond_holder) {
        this.bond_holder = bond_holder;
    }

    public Bond getBond_reference() {
        return bond_reference;
    }

    public void setBond_reference(Bond bond_reference) {
        this.bond_reference = bond_reference;
    }

    public Books getBook_reference() {
        return book_reference;
    }

    public void setBook_reference(Books book_reference) {
        this.book_reference = book_reference;
    }
}
