package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUsers;
import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.repository.BooksUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookUsersHandler implements IBookUsersService{
    private BooksUsersRepository bookRepo;

    @Autowired
    public BookUsersHandler( BooksUsersRepository bookRep ) {this.bookRepo = bookRep;}

    @Override
    public List<String> getAllBookUsers(String bondholder) {return bookRepo.getAllBooksUser(bondholder);}

    @Override
    public Books getBookUsersById(String uniqueId) {return bookRepo.findById(uniqueId).get();}

//    @Override
//    public BookUsers addBookUsers(BookUsers theBookUsers) {return bookRepo.save( theBookUsers );}
//
//    @Override
//    public BookUsers updateBookUsersDetails(BookUsers bookDetails) {
//        return bookRepo.save(bookDetails);
//    }

//    @Override
//    public boolean removeBookUser(int id) {
//        boolean result = false;
//
//        Optional<BookUsers> theBookUser = bookRepo.findById(id);
//        if(theBookUser.isPresent())
//        {
//            bookRepo.delete(theBookUser.get());
//            result = true;
//        }
//
//        return  result;
//    }
}
