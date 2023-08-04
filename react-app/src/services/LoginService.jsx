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