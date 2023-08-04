package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IService<Book>{
    private BookRepository bookRepo;


    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public int getNoOf() {
        return 0;
    }

    @Override
    public Book getById(Integer uniqueId) {
        return null;
    }

    @Override
    public Book getByName(String issuer) {
        return null;
    }
}
