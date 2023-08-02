package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BondServiceImpl implements BondService {
    private final BondsRepository bondsRepository;

    @Autowired
    public BondServiceImpl(BondsRepository bondsRepository) {
        this.bondsRepository = bondsRepository;
    }

    @Override
    public List<Bond> getAllBonds() {
        return bondsRepository.findAll();
    }

    @Override
    public List<Bond> getAllBondsForBusinessDaysBeforeAndAfter(Date date, int daysBefore, int daysAfter) {
        List<Bond> bonds5BusinessDaysBeforeAndAfter = new ArrayList<>();
        Date startDate = addBusinessDays(date, daysBefore);//-5
        Date endDate = addBusinessDays(date, daysAfter);//5
        for (Bond bond : bondsRepository.findAll()) {
             if (!bond.getBondMaturityDate().before(startDate) && !bond.getBondMaturityDate().after(endDate)) {
                 bonds5BusinessDaysBeforeAndAfter.add(bond);
             }
        }
        return bonds5BusinessDaysBeforeAndAfter;
    }

    private Date addBusinessDays(Date date, int days) {//utility class
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTime(date);
        int direction = days > 0 ? 1 : -1;

        for (int i = 0; i < Math.abs(days); ) {
            calendar.add(Calendar.DAY_OF_MONTH, direction);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                i++;
            }
        }

        return calendar.getTime();
    }
}
