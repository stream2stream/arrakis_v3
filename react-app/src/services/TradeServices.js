
import http from './axios-common';



export function getAllBonds(){
  return http.get("/bonds");
}

// export const findBonds = () => {
//   const pets = axios.get(`${hostNameUrl}/dogs`);
//   return pets;
// };