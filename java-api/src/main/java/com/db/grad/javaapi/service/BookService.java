package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IService<Book>{
    private BookRepository bookRepo;

    @Autowired
    public BookService (BookRepository bp){
        bookRepo = bp;
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public int getNoOf() {
        return (int) bookRepo.count();
    }

    @Override
    public Book getById(Integer uniqueId) {
        return bookRepo.findById(uniqueId).get();
    }

    @Override
    public List<Book> getByName(String issuer) {
        List<Book> books = bookRepo.findBook(issuer);
        List<Book> result = null;
        if (books.size() >= 1)
            result = books;
        return result;
    }
}
