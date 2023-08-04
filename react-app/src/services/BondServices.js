import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findUsers = () => {
  const users = axios.get(`${hostNameUrl}/User`);
  return users;
};

export const getBookingId = (user) => {
  const id = axios.get(`${hostNameUrl}/User/getId/${user}`);
  return id;
}

export const getMaturityDates = (user) => {
  const dates = axios.get(`${hostNameUrl}/`);
  return dates;
}