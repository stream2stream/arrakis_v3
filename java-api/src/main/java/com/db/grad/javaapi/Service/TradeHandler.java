package com.db.grad.javaapi.Service;


import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TradeHandler implements ITradeService{

    private TradeRepository tradeRepository;

    @Autowired
    public TradeHandler(TradeRepository TradeRepository) {
        this.tradeRepository = TradeRepository;
    }

    @Override
    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    @Override
    public Trade addTrade(Trade theTrade) {
        return tradeRepository.save(theTrade);
    }

    @Override
    public long getNoOfTrades() {
        return tradeRepository.count();
    }

    @Override
    public boolean removeTrade(long uniqueId) {
        boolean result = false;

        Optional<Trade> theTrade = tradeRepository.findById(uniqueId);
        if(theTrade.isPresent())
        {
            tradeRepository.delete(theTrade.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Trade getTradeById(long uniqueId) {
//        Trade TradeToFind = new Trade();
//        TradeToFind.setId(uniqueId);
        Optional<Trade> theTrade = tradeRepository.findById(uniqueId);
        if(theTrade.isPresent())
        {
            return theTrade.get();
        } else {
            throw new NotFoundException("Trade not found with id: " + uniqueId);
        }
    }


    public List<Trade> getTradesBySecuritiesID(List<Long> securityIds){
        if (securityIds == null) return null;
        if (securityIds.isEmpty()) return new ArrayList<>();
        return tradeRepository.findTradesBySecuritiesID(securityIds);
    }

    @Override
    public Trade updateTradeDetails(Trade TradeToUpdate) {
        return tradeRepository.save(TradeToUpdate);
    }

    public List<Trade> filterTradeByBidType(String bid){
        String bidLower = bid.toLowerCase();
        return tradeRepository.findTradeByBidType(bidLower);
    }

    public List<Trade> getTradesBySettlementDate(String settlementDate) {
        Date settlementDateSQL=Date.valueOf(settlementDate);
        return tradeRepository.getTradesBySettlementDate(settlementDateSQL);
    }
}