package service;

import com.db.grad.javaapi.Service.TradeHandler;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TradeHandlerTest
{
    @Mock
    private TradeRepository itsTradesRepo;

    @InjectMocks
    private TradeHandler cut;

    @Test
    public  void    test_add_a_trade_return_number_of_trade_in_repo_is_one()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setSettlement_date(Date.valueOf("2012-08-23"));
        Mockito.when(itsTradesRepo.save(theTrade)).thenReturn(theTrade);
        Mockito.when(itsTradesRepo.count()).thenReturn(1L);
        cut.addTrade( theTrade );
        int expectedResult = 1;
        // act
        long actualResult = cut.getNoOfTrades();
        // assert
        assertEquals( expectedResult, actualResult );
    }


    @Test
    public  void    test_update_trade_details_return_()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setSettlement_date(Date.valueOf("2012-08-23"));
        Mockito.when(itsTradesRepo.save(theTrade)).thenReturn(theTrade);
        Mockito.when(itsTradesRepo.count()).thenReturn(1L);
        cut.addTrade( theTrade );
        int expectedResult = 1;
        // act
        long actualResult = cut.getNoOfTrades();
        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public  void  test_get_trades_by_securities_id()
    {
        // arrange
        Trade trade1 = new Trade();
        trade1.setSecurity_id(1);
        Trade trade2 = new Trade();
        trade2.setSecurity_id(1);
        Trade trade3 = new Trade();
        trade3.setSecurity_id(2);
        Trade trade4 = new Trade();
        trade4.setSecurity_id(3);
        List<Trade> mockTrades = Arrays.asList(
                trade1, trade2, trade3
        );
        List<Long> securitiesID = Arrays.asList(1L, 2L);
        Mockito.when(itsTradesRepo.findTradesBySecuritiesID(securitiesID)).thenReturn(mockTrades);
        cut.addTrade( trade1 );
        cut.addTrade( trade2 );
        cut.addTrade( trade3 );
        cut.addTrade( trade4 );
        int expectedResult = 3;
        // act
        List<Trade> actualResultList = cut.getTradesBySecuritiesID(securitiesID);
        int actualResult = actualResultList.size();
        // assert
        assertEquals( expectedResult, actualResult);
    }




    @Test
    public  void   test_filter_trade_by_bid_type()
    {
        // arrange
        Trade trade1 = new Trade();
        trade1.setBuy_sell("buy");
        Trade trade2 = new Trade();
        trade2.setBuy_sell("sell");
        List<Trade> mockTrades = Arrays.asList(
                trade1
        );

        Mockito.when(itsTradesRepo.findTradeByBidType("buy")).thenReturn(mockTrades);

        cut.addTrade( trade1 );
        cut.addTrade( trade2 );
        int expectedResult = 1;
        // act
        List<Trade> actualResultList = cut.filterTradeByBidType("buy");
        int actualResult = actualResultList.size();
        // assert
        assertEquals( expectedResult, actualResult);
    }



    @Test
    public  void   test_filter_trade_based_on_settlement_date()
    {
        // arrange
        Trade trade1 = new Trade();
        trade1.setSettlement_date(Date.valueOf("2012-08-23"));
        Trade trade2 = new Trade();
        trade2.setSettlement_date(Date.valueOf("2012-08-22"));
        List<Trade> mockTrades = Arrays.asList(
                trade1
        );

        Mockito.when(itsTradesRepo.getTradesBySettlementDate(Date.valueOf("2012-08-23"))).thenReturn(mockTrades);

        cut.addTrade( trade1 );
        cut.addTrade( trade2 );
        int expectedResult = 1;
        // act
        List<Trade> actualResultList = cut.getTradesBySettlementDate("2012-08-23");
        int actualResult = actualResultList.size();
        // assert
        assertEquals( expectedResult, actualResult);
    }
}
