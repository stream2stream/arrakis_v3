import axios from "axios";

export const findBonds = () => {
  return axios.get(`http://localhost:8080/securities`);
}

export const findCounterParty = (map) => {
  return axios.post(`http://localhost:8080/securities/counterparty`, map);
}