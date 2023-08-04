package com.db.grad.javaapi.service;

import java.util.List;

public interface IService<T> {

    public List<T> getAll();

//    public T addBond(T bondDetails);

    public int getNoOf();

//    public boolean removeBonds(Integer uniqueId);

    public T getById(Integer uniqueId);

    public T getByName(String issuer);

//    public T updateIssuerDetails(T bondToUpdate);
}
