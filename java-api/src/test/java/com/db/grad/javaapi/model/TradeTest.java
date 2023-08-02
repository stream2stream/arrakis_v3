package com.db.grad.javaapi.model;
import com.db.grad.javaapi.repository.TradesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeTest {
    @Mock
    private TradesRepository tradesRepository;


    @Test
    public void addTradeAndReturnNumberOfTradesInRepo() {
        Trade trade = new Trade();
        trade.setIsin("ISIN2");
        trade.setBookName("trading_book_1");
        trade.setBondHolderID(2);
        trade.setStatus("open");
        trade.setUnitPrice(90);
        trade.setTradeCurrency("USD");
        trade.setTradeType("buy");
        Date date = new Date(2023, 01, 01);
        trade.setTradeDate(date);
        trade.setTradeSettlementDate(date);
        trade.setQuantity(50);
        tradesRepository.save(trade);

        int expectedResult = 1;
        assertEquals(1, tradesRepository.count());
    }

    @Test
    public void addSeveralTradesAndReturnNumberOfBondsInRepo() {
        Trade trade = new Trade();
        trade.setIsin("ISIN2");
        trade.setBookName("trading_book_1");
        trade.setBondHolderID(2);
        trade.setStatus("open");
        trade.setUnitPrice(90);
        trade.setTradeCurrency("USD");
        trade.setTradeType("buy");
        Date date = new Date("2023-01-01");
        trade.setTradeDate(date);
        trade.setTradeSettlementDate(date);
        trade.setQuantity(50);
        tradesRepository.save(trade);

        Trade trade1 = new Trade();
        trade1.setIsin("ISIN3");
        trade1.setBookName("trading_book_2");
        trade1.setBondHolderID(3);
        trade1.setStatus("open");
        trade1.setUnitPrice(100);
        trade1.setTradeCurrency("USD");
        trade1.setTradeType("buy");
        trade1.setTradeDate(date);
        trade1.setTradeSettlementDate(date);
        trade1.setQuantity(50);
        tradesRepository.save(trade1);

        Trade trade2 = new Trade();
        trade2.setIsin("ISIN4");
        trade2.setBookName("trading_book_3");
        trade2.setBondHolderID(4);
        trade2.setStatus("open");
        trade2.setUnitPrice(100);
        trade2.setTradeCurrency("USD");
        trade2.setTradeType("buy");
        trade2.setTradeDate(date);
        trade2.setTradeSettlementDate(date);
        trade2.setQuantity(50);
        tradesRepository.save(trade2);

        int expectedResult = 3;
        assertEquals(expectedResult, tradesRepository.count());
    }

    @Test
    public void findTradeByValidId(){
        Date date = new Date("2023-01-01");
        Trade trade1 = new Trade();
        trade1.setIsin("ISIN4");
        trade1.setBookName("trading_book_3");
        trade1.setBondHolderID(4);
        trade1.setStatus("open");
        trade1.setUnitPrice(100);
        trade1.setTradeCurrency("USD");
        trade1.setTradeType("buy");
        trade1.setTradeDate(date);
        trade1.setTradeSettlementDate(date);
        trade1.setQuantity(50);
        tradesRepository.save(trade1);

        assertEquals(trade1, tradesRepository.getReferenceById("ISIN4"));
    }
}
