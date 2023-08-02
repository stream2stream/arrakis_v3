import { hostNameUrl } from "../config/api";
import axios from "axios";

export const getAllBonds = () => {
  const bonds = [
    {
        issuerName:'BNPParibasIssu 4,37% Microsoft Corp (USD)',
        isin:'XS1988387210',
        bondMaturityDate:'05/08/2021',
        couponPercent:4.37,
        faceValue:1000
    }, {
        issuerName:'Airbus 3.15%  USD',
        isin:'USN0280EAR64',
        bondMaturityDate:'30/07/2021',
        couponPercent:3.15,
        faceValue:900
    },{
        issuerName:'UBS Facebook (USD)',
        isin:'A12356111',
        bondMaturityDate:'30/09/2021',
        couponPercent:2,
        faceValue:900
    }
  ]; //axios.get(`${hostNameUrl}/dogs`);
  return pets;
};