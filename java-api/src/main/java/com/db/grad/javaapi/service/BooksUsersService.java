package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.BooksUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksUsersService{

    @Autowired
    private BooksUsersRepository bookUserRepo;

    public List<String> getAllBooksUserS(String bonholder) {return bookUserRepo.getAllBooksUser(bonholder);}

}
