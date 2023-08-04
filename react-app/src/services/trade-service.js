import http from './axios-common';

export function getAllTrades(securityIds){
    return http.get("/trades/securityIDs",securityIds);
}