package com.db.grad.javaapi.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class DataLoader {

    private final BookRepository bookRepository;
    private final TradeRepository tradeRepository;
    private final BondRepository bondRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository, TradeRepository tradeRepository, BondRepository bondRepository) {
        this.bookRepository = bookRepository;
        this.tradeRepository = tradeRepository;
        this.bondRepository = bondRepository;
    }

    @PostConstruct
    public void loadDataFromCsv() {
        try {
            ClassPathResource resource = new ClassPathResource("db-bonds-data.csv");
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String tradeType = data[0];
                String tradeCurrency = data[1];
                Integer quantity = Integer.parseInt(data[2]);
                String tradeSettlementDate = data[3];

//                bool
                String tradeStatus = data[4];
                String tradeDate = data[5];
                Double unitPrice = Double.parseDouble(data[6]);
                Double couponPercent = Double.parseDouble(data[7]);
                String bondCurrency = data[8];
                String cusip = data[9];
                Double faceValue = Double.parseDouble(data[10]);
                String isin = data[11];
                String issuerName = data[12];
                String bondMaturityDate = data[13];

                    //    bool
                String bondStatus = data[14];
                String type = data[15];
                String bookName = data[16];
                String bondHolder = data[17];

                // Create and save Bond entity
//                Bond bond = new Bond();
//                bond.setCouponPercent(couponPercent);
//                bond.setBondCurrency(bondCurrency);
//                bond.setCusip(cusip);
//                bond.setFaceValue(faceValue);
//                bond.setIsin(isin);
//                bond.setIssuerName(issuerName);
//                bond.setBondMaturityDate(bondMaturityDate);
//                bond.setBondStatus(bondStatus);
//                bond.setType(type);
//                bondRepository.save(bond);
//
//                // Create and save Book entity
//                Book book = new Book();
//                book.setBookName(bookName);
//                bookRepository.save(book);
//
//                // Create and save Trade entity
//                Trade trade = new Trade();
//                trade.setTradeType(tradeType);
//                trade.setTradeCurrency(tradeCurrency);
//                trade.setQuantity(quantity);
//                trade.setTradeSettlementDate(tradeSettlementDate);
//                trade.setTradeStatus(tradeStatus);
//                trade.setTradeDate(tradeDate);
//                trade.setUnitPrice(unitPrice);
//                trade.setBond(bond);
//                trade.setBook(book);
//                tradeRepository.save(trade);

            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
