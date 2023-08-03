package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondsRepository;
import com.db.grad.javaapi.service.model.MaturingBondType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public Map<String, MaturingBondType> getAllBondsForBusinessDaysBeforeAndAfter(String date, int daysBefore, int daysAfter) throws ParseException {
        List<Bond> bonds5BusinessDaysBeforeAndAfter = new ArrayList<>();
        // convert date from String to Date
        Date actualDate = convertStringToDate(date);

        Date startDate = addBusinessDays(actualDate, (-1) * daysBefore);//-5
        Date endDate = addBusinessDays(actualDate, daysAfter);//5

        for (Bond bond : bondsRepository.findAll()) {
             if (bond.getBondMaturityDate().after(startDate) && bond.getBondMaturityDate().before(endDate)) {
                 bonds5BusinessDaysBeforeAndAfter.add(bond);
             }
        }
        Map<String, MaturingBondType> maturingBondTypeMap = new HashMap<>();
        for (Bond bond : bonds5BusinessDaysBeforeAndAfter){
            bond.getType();
            bond.getBondMaturityDate();
            MaturingBondType maturingBondType;
            maturingBondType.setBondType(bond.getType());
            maturingBondTypeMap.put(bond.getBondMaturityDate(), )
        }
        return bonds5BusinessDaysBeforeAndAfter;
    }

    private Date convertStringToDate(String date) throws ParseException {
        String format = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(date);
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
