package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooksForUser(String userMail){
        return bookRepository.findBooksByUserId(userMail);
    }
    public List<Security> getAllSecuritiesForUserBooks(Long userId){
        return securityRepository.findSecuritiesForUserBooks(userId);
    }
}
