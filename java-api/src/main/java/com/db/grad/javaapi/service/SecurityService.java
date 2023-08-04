package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dto.BondDTO;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Security> getAllSecuritiesForUserBooks(String userMail){
        return securityRepository.findSecuritiesForUserBooks(userMail);
    }
    public List<Security> getBonds() {
        return securityRepository.getActiveBonds();
    }
}
