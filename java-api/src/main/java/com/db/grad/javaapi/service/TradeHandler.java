package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TradeHandler implements ITradeHandler {
        private TradeRepository itsTradesRepo;

        @Autowired
        public TradeHandler(TradeRepository tradeRepo) {
                itsTradesRepo = tradeRepo;
        }

        @Override
        public List<Trade> getAllTrades() {
                return itsTradesRepo.findAll();
        }

        public Trade addTrade(Trade newTrade){
                return itsTradesRepo.save(newTrade);
        }

        public long getNoOfTrades(){
                return itsTradesRepo.count();
        }

        public List<Trade> getTradesByBookId(long id){
                List<Trade> trades = itsTradesRepo.getTradesByBookId(id);
                return trades;
        }

        public List<Trade> getTradesBeforeMaturity(long id){
                List<Trade> trades = itsTradesRepo.getTradesBeforeMaturity(id);
                return trades;
        }

        public List<String> getTradeDisplay(long id){
                List<String> trades = itsTradesRepo.getTradeDisplay(id);
                return trades;
        }

//        public Trade getTradeByBookId(long id){
//                return itsTradesRepo.findById()
//        }
//        public List<Trade> getTradesByBookId(long id){
//
//        }



}
