package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeHandler implements ITradeService{

    private TradeRepository TradeRepository;

    @Autowired
    public TradeHandler(TradeRepository TradeRepository) {
        this.TradeRepository = TradeRepository;
    }

    @Override
    public List<Trade> getAllTrades() {
        return TradeRepository.findAll();
    }

    @Override
    public Trade addTrade(Trade theTrade) {
        return TradeRepository.save(theTrade);
    }

    @Override
    public long getNoOfTrades() {
        return TradeRepository.count();
    }

    @Override
    public boolean removeTrade(long uniqueId) {
        boolean result = false;

        Optional<Trade> theTrade = TradeRepository.findById(uniqueId);
        if(theTrade.isPresent())
        {
            TradeRepository.delete(theTrade.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Trade getTradeById(long uniqueId) {
        Trade TradeToFind = new Trade();
        TradeToFind.setId(uniqueId);
        List<Trade> Trades = TradeRepository.findByTradeID(TradeToFind);
        Trade result = null;

        if( Trades.size() == 1)
            result = Trades.get(0);

        return result;
    }

    @Override
    public Trade getTradeByBookID(long BookID) {
        Trade TradeToFind = new Trade();
        TradeToFind.setBook_id(BookID);
        List<Trade> Trades = TradeRepository.findByBookID(TradeToFind);
        Trade result = null;

        if( Trades.size() == 1)
            result = Trades.get(0);

        return result;
    }



    @Override
    public Trade updateTradeDetails(Trade TradeToUpdate) {
        return TradeRepository.save(TradeToUpdate);
    }
}