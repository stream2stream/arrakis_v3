package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.TradesCounterParty;
import com.db.grad.javaapi.repository.TradesCounterPartiesRepository;
import com.db.grad.javaapi.repository.TradesRepository;
import com.db.grad.javaapi.utils.Triple;
import com.google.cloud.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TradeServiceImpl implements TradeService {

    private final TradesRepository tradesRepository;
    private TradesCounterPartyService tradesCounterPartiesService;

    @Autowired
    public TradeServiceImpl(TradesRepository tradesRepository, TradesCounterPartyService tradesCounterPartyService) {
        this.tradesRepository = tradesRepository;
        this.tradesCounterPartiesService = tradesCounterPartyService;
    }

    @Override
    public List<Trade> getAllTradesByISIN(String ISIN) {
        List<Trade> tradesByISIN = new ArrayList<>();

        for (Trade trade : tradesRepository.findAll()) {
            if (trade.getIsin().equals(ISIN)) {
                tradesByISIN.add(trade);
            }
        }
        return tradesByISIN;
    }

    // return bondHolderName | bondHolderNumberOfBonds | bondHolderCurrentPosition
    @Override
    public Triple<String, Integer, Double> getStatsByBondHolderID(int bondHolderId) {

        // -> bondHolderName
        String bondHolderName = tradesCounterPartiesService.getBondHolderNameByID(bondHolderId);

        int bondHolderNumberOfBonds;
        List<Trade> listOfTradesByBondHolderId = new ArrayList<>();
        List<String> listOfCountedIsins = new ArrayList<>();
        double bondHolderCurrentPosition = 0;

        // get the trades that have bondHolderId
        for (Trade trade : tradesRepository.findAll()) {
            if (trade.getBondHolderID() == bondHolderId) {
                listOfTradesByBondHolderId.add(trade);
            }
        }

        // get all the unique ISINS
        for (Trade trade : listOfTradesByBondHolderId) {
            String isin = trade.getIsin();
            if (!listOfCountedIsins.contains(isin)) {
                listOfCountedIsins.add(isin);
            }
        }

        // -> bondHolderNumberOfBonds
        bondHolderNumberOfBonds = listOfCountedIsins.size();

        for (Trade trade : listOfTradesByBondHolderId) {
            if (!trade.getTradeCurrency().equals("USD")) {
                bondHolderCurrentPosition += convertGBPToUSD(trade.getUnitPrice()) * trade.getQuantity();
            } else {
                bondHolderCurrentPosition += trade.getUnitPrice() * trade.getQuantity();
            }
        }

        Triple<String, Integer, Double> tradesStats = new Triple<>(bondHolderName, bondHolderNumberOfBonds, bondHolderCurrentPosition);

        return tradesStats;
    }

    public double convertGBPToUSD(double priceGBP) {
        final double GBP_TO_USD_RATE = 1.37;
        return priceGBP * GBP_TO_USD_RATE;
    }
}
