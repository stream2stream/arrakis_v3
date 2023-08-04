import { hostNameUrl } from "../config/api";
import axios from "axios";

export const getAllTrades = () => {
  const data = axios.get(`${hostNameUrl}/trades`);
  return data;
};