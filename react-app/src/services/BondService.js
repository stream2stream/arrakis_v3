import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findPets = () => {
  const pets = axios.get(`${hostNameUrl}/dogs`);
  return pets;
};

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