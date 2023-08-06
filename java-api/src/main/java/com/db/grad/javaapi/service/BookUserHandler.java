package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.BookUserRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookUserHandler {
    @Autowired
    private BookUserRepository bookUserRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BookRepository bookRepo;

    public List<Book> getAllBooksByUserEmail(String email){
         Optional<User> user = userRepo.findByEmail(email);
         if(user.isEmpty())
             return new ArrayList<>();
         else
         {
             int id = user.get().getId();
             List<BookUser> bookUserList = bookUserRepo.findByUserId(id);
             List<Book> bookList = new ArrayList<>();
             for (BookUser bookUser : bookUserList){
                 bookList.add(bookUser.getBook());
             }
             return bookList;
         }

    }

}
