
import http from './axios-common';



export function getAllBonds(){
  return http.get("/bonds");
}
export function getAllBondsMaturity(date){
  return http.get("/bonds/maturity?date=" + date.toISOString().split('T')[0]);
}
export function getAllTrades(){
  return http.get("/trades");
}

// export const findBonds = () => {
//   const pets = axios.get(`${hostNameUrl}/dogs`);
//   return pets;
// };