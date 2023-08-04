package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trades;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeHandler implements ITradeService{
        private TradeRepository tradeRepo;

        @Autowired
        public TradeHandler( TradeRepository tradeRep ) {this.tradeRepo = tradeRep;}

        @Override
        public List<Trades> getAllTrades() {return tradeRepo.getAllTrades();}

        @Override
        public Trades getTradesById(Long id) {
                return tradeRepo.findById(id).get();
        }

        @Override
        public Trades updateTradeDetails(Trades tradeToUpdate) {return tradeRepo.save( tradeToUpdate );}

        @Override
        public boolean removeTrade(long uniqueId)
        {
                boolean result = false;

                Optional<Trades> theTrade = tradeRepo.findById(uniqueId);
                if(theTrade.isPresent())
                {
                        tradeRepo.delete(theTrade.get());
                        result = true;
                }

                return  result;
        }

        @Override
        public Trades addTrade(Trades trade) {
                return tradeRepo.save(trade);
        }
}
