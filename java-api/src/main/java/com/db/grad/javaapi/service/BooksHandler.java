package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksHandler implements BooksService {
    private BooksRepository itsBooksRepo;

    @Autowired
    public BooksHandler(BooksRepository bookRepo) {
        itsBooksRepo = bookRepo;
    }


}