import { hostNameUrl } from "../config/api";
import axios from "axios";

const bonds = [
    {
        issuerName:'BNPParibasIssu 4,37% Microsoft Corp (USD)',
        isin:'XS1988387210',
        bondMaturityDate:Date.parse('05/08/2021'),
        couponPercent:4.37,
        faceValue:1000
    }, {
        issuerName:'Airbus 3.15%  USD',
        isin:'USN0280EAR64',
        bondMaturityDate:Date.parse('30/07/2021'),
        couponPercent:3.15,
        faceValue:900
    },{
        issuerName:'UBS Facebook (USD)',
        isin:'A12356111',
        bondMaturityDate:Date.parse('30/09/2021'),
        couponPercent:2,
        faceValue:900
    }
  ]

export const getAllBonds = () => {
  ; //axios.get(`${hostNameUrl}/dogs`);
  return bonds;
};

export const getBondByDate = (date) => {
    return bonds.filter(function(itm) {
        return itm.bondMaturityDate == date;
    })
}

export const getBondsByDates = (date) => {
    bonds = []
    for (var i = -5; i <= 5; i++) {
        bonds.append(getBondByDate(date+i));
    }
    return bonds;
}