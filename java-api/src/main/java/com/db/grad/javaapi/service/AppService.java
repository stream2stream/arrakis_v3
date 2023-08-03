package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppService {

    BondService bondService;

    TradeService tradeService;

    BookService bookService;

    UserService userService;

    TradeCounterPartyService tradeCounterPartyService;

    BondCounterPartyService bondCounterPartyService;



    @Autowired
    public AppService(TradeService ts, BondService bondService, BookService bookService, UserService userService, TradeCounterPartyService tradeCounterPartyService, BondCounterPartyService bondCounterPartyService) {
        this.bondService = bondService;
        this.tradeService = ts;
        this.bookService = bookService;
        this.userService = userService;
        this.tradeCounterPartyService = tradeCounterPartyService;
        this.bondCounterPartyService = bondCounterPartyService;
    }

    public List<Trade> getAllTrades(){
        return tradeService.getAllTrades();
    }

    public List<Bond> getAllBonds(){
        return bondService.getAllBonds();
    }

    public List<Book> getAllBooks(){return bookService.getAllBooks();}

    public List<TradeCounterParty> getAllTradeCounterParties(){
        return tradeCounterPartyService.getAllTradeCounterParties();
    }

    public List<BondCounterParty> getAllBondCounterParties(){
        return bondCounterPartyService.getAllBondCounterParties();
    }

    public void assignBooksToUser(int userId, List<Integer> bookIds) {
        User user = userService.findById(userId);
        List<Book> books = bookService.findAllById(bookIds);
        user.setBooks(books);
        userService.save(user);
    }

    public List<Bond> findBondsByBookId(int bookId){
        return bondService.findBondsByBookId(bookId);
    }

    public List<Bond> findBondsWithMaturityDateInFiveDays(LocalDate currentDate){
        return bondService.findBondsWithMaturityDateInFiveDays(currentDate);
    }

    public List<Bond> findBondsWithMaturityDateFiveDaysBefore(LocalDate currentDate){
        return bondService.findBondsWithMaturityDateFiveDaysBefore(currentDate);
    }

    public User addUserByName(String name){
        return userService.addUserByUsername(name);
    }
}
