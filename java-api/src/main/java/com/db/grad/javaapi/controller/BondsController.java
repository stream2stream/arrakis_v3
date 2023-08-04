package com.db.grad.javaapi.controller;
import java.util.ArrayList;
import java.util.List;

import com.db.grad.javaapi.model.BondsDTO;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradesRepository;
import com.db.grad.javaapi.service.BooksService;
import com.db.grad.javaapi.service.CounterPartiesService;
import com.db.grad.javaapi.service.SecuritiesService;
import com.db.grad.javaapi.service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BondsController {
    @Autowired
    private TradesService tradesService;
    @Autowired
    private SecuritiesService securityService;
    @Autowired
    private BooksService booksService;
    @Autowired
    private CounterPartiesService counterParty;

    @GetMapping("/bonds")
    public ResponseEntity<List<BondsDTO>> getAllBonds(){
        List<Book> books = booksService.getAllBooks();
        List<BondsDTO> bondsDataList = new ArrayList<>();

        for(Book book: books){
            List<Trade> trades = (List<Trade>) tradesService.getTradeById(book.getId());
            BondsDTO bonds = new BondsDTO();
            bonds.setBook(book);
            bonds.setTrades(trades);
            bondsDataList.add(bonds);
        }
        return ResponseEntity.ok(bondsDataList);
    }
}
