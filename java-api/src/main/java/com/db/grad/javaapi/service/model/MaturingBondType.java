package com.db.grad.javaapi.service.model;

public class MaturingBondType {
    String bondType;
    int numberOfBondsMaturing;

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public int getNumberOfBondsMaturing() {
        return numberOfBondsMaturing;
    }

    public void setNumberOfBondsMaturing(int numberOfBondsMaturing) {
        this.numberOfBondsMaturing = numberOfBondsMaturing;
    }
}
