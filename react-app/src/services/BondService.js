import { hostNameUrl } from "../config/api";
import axios from "axios";

export const getAllBonds = async () => {
  try {
    const response = await axios.get(`${hostNameUrl}/bonds`);
    const bonds = response.data;
    return bonds;
  } catch (error) {
    console.error("Error fetching bonds:", error);
    throw error;
  }
};

export const getAllTradesByISIN = async (isin) => {
  try {
    const response = await axios.get(`${hostNameUrl}/trades/isin/${isin}`);
    const trades = response.data;
    return trades;
  } catch (error) {
    console.error("Error fetching trades:", error);
    throw error;
  }
};

export const getAllBondsForBusinessDaysBeforeAndAfter = async (date) => {
  const daysBefore = 5;
  const daysAfter = 5;
  try {
    const response = await axios.get(`${hostNameUrl}/bonds/dates/${date}/${daysBefore}/${daysAfter}`);
    const bonds = response.data;
    return bonds;
  } catch (error) {
    console.error("Error fetching bonds:", error);
    throw error;
  }
};