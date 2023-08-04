package com.db.grad.javaapi.model;
import java.util.List;
public class BondsDTO {
    private List<Trade> trades;
    private Security security;
    private CounterParty counterParty;
    private Book book;

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public CounterParty getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(CounterParty counterParty) {
        this.counterParty = counterParty;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
