package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BooksHandler {
    private BooksRepository bookRepo;

    @Autowired
    public BooksHandler(BooksRepository bookRep ) {this.bookRepo = bookRep;}

    public List<Books> getAllBooks() {return bookRepo.getAllBooks();}

    public List<String> getBondsPlusMinus(String date) {return bookRepo.getBondsPlusMin(date);}

    public List<String> getMatDate() {return bookRepo.getMatDate();}


}
