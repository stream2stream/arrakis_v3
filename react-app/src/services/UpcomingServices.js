import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findUpcoming = (date) => {
  console.log(date);
  let upcoming;
  if (date === "") {
    upcoming = axios.get(`${hostNameUrl}/securities/T5`);
  } else {
    console.log(date);
    upcoming = axios.get(`${hostNameUrl}/securities/T5/${date}`);
  }
  return upcoming;
};