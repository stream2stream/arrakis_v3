import http from './axios-common';
export function getAllBondsOfAUser(bondHolder){
    return http.get(`/getBondsOfUser/${encodeURIComponent(bondHolder)}`);
}