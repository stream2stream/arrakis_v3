import http from './axios.common';

export function checkDateBonds(date){
    return http.post("/securities/maturity", date);

}