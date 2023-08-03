package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    BondService bondService;

    TradeService tradeService;

    BookService bookService;

    UserService userService;



    @Autowired
    public AppService(TradeService ts, BondService bondService, BookService bookService, UserService userService) {
        this.bondService = bondService;
        this.tradeService = ts;
        this.bookService = bookService;
        this.userService = userService;
    }

    public List<Trade> getAllTrades(){
        return tradeService.getAllTrades();
    }

    public List<Bond> getAllBonds(){
        return bondService.getAllBonds();
    }

    public List<Book> getAllBooks(){return bookService.getAllBooks();}

    public void assignBooksToUser(int userId, List<Integer> bookIds) {
        User user = userService.findById(userId);
        List<Book> books = bookService.findAllById(bookIds);
        user.setBooks(books);
        userService.save(user);
    }

//    public List<Bond> findBondsByBookId(int bookId){
//        return bondService.findBondsByBookId(bookId);
//    }
}
