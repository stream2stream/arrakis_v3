package com.db.grad.javaapi.service;


import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository br;
    
    private UserRepository ur ; 

    @Autowired
    public BookService(BookRepository br, UserRepository ur) {
        this.br = br;
        this.ur = ur ;
    }


    public List<Book> getAllBooks() {
        return br.findAll();
    }


    public List<Book> findAllById(List<Integer> bookIds) {
        return br.findAllById(bookIds);
    }

    public List<Book> findBooksByUserID(int userID) {
        Optional<User> optfoundUser = ur.findById(userID) ;
        return  optfoundUser.get().getBooks();
    }
}
