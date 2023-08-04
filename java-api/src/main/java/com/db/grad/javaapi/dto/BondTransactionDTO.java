package com.db.grad.javaapi.dto;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;

import java.util.ArrayList;

public class BondTransactionDTO {

    private ArrayList<Trade> transactions;
    private Security security;

    public BondTransactionDTO() {
    }

    public ArrayList<Trade> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Trade> transactions) {
        this.transactions = transactions;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    @Override
    public String toString() {
        return "BondTransactionDTO{" +
                "transactions=" + transactions +
                ", security=" + security +
                '}';
    }
}
