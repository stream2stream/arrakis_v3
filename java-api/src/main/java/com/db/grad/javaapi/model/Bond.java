package com.db.grad.javaapi.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
public class Bond implements Serializable {

    @Id
    @Column(name="id", insertable = false, updatable = false)
    private int id;

    @Column(name="isin")
    private String isin;

    @Column(name="bond_maturity_date")
    private String bond_maturity_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getBond_maturity_date() {
        return bond_maturity_date;
    }

    public void setBond_maturity_date(String bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "id=" + id +
                ", isin='" + isin + '\'' +
                ", bond_maturity_date='" + bond_maturity_date + '\'' +
                '}';
    }
}
