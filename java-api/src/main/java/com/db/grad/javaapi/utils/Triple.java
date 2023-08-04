package com.db.grad.javaapi.utils;

public class Triple<A, B, C> {
    private A bondHolderName;
    private B bondHolderNumberOfBonds;
    private C bondHolderCurrentPosition;


    public Triple(A bondHolderName, B bondHolderNumberOfBonds, C bondHolderCurrentPosition) {
        this.bondHolderName = bondHolderName;
        this.bondHolderNumberOfBonds = bondHolderNumberOfBonds;
        this.bondHolderCurrentPosition = bondHolderCurrentPosition;
    }

    public A getBondHolderName() {
        return bondHolderName;
    }

    public void setBondHolderName(A bondHolderName) {
        this.bondHolderName = bondHolderName;
    }

    public B getBondHolderNumberOfBonds() {
        return bondHolderNumberOfBonds;
    }

    public void setBondHolderNumberOfBonds(B bondHolderNumberOfBonds) {
        this.bondHolderNumberOfBonds = bondHolderNumberOfBonds;
    }

    public C getBondHolderCurrentPosition() {
        return bondHolderCurrentPosition;
    }

    public void setBondHolderCurrentPosition(C bondHolderCurrentPosition) {
        this.bondHolderCurrentPosition = bondHolderCurrentPosition;
    }
}
