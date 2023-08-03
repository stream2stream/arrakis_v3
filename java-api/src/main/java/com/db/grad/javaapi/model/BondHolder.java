package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bond_holder")
public class BondHolder {
    @Id
    @Column(name = "bond_holder_name")
    private String bondHolderName;

    public String getBondHolderName() {
        return bondHolderName;
    }

    public void setBondHolderName(String bondHolderName) {
        this.bondHolderName = bondHolderName;
    }

    @Override
    public String toString() {
        return "BondHolder{" +
                "bondHolderName='" + bondHolderName + '\'' +
                '}';
    }
}
