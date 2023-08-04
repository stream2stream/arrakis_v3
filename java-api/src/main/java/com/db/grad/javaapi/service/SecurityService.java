package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dto.BondTransactionDTO;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TradeRepository tradeRepository;

    public List<Security> getAllSecuritiesForUserBooks(String userMail) {
        return securityRepository.findSecuritiesForUserBooks(userMail);
    }

    public List<Security> getBonds() {
        return securityRepository.getActiveBonds();
    }

    public ArrayList<BondTransactionDTO> getActiveBondsTransactions() {

        List<Trade> transactions = tradeRepository.getAllTransactions();
        List<Security> securities = securityRepository.getActiveBonds();
        ArrayList<BondTransactionDTO> bondTransactionAll = new ArrayList<>();

        for (Security security : securities) {
            BondTransactionDTO btdo = new BondTransactionDTO();
            btdo.setSecurity(security);
            ArrayList<Trade> currentTransactions = new ArrayList<Trade>();

            for (Trade transaction : transactions) {
                if (transaction.getSecurity_id() == security.getId()) {
                    currentTransactions.add(transaction);
                }
            }
            btdo.setTransactions(currentTransactions);
            bondTransactionAll.add(btdo);
        }
        return bondTransactionAll;
    }
}
