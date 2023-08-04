import http from './axios-common';

export function getAllSecurities(userIds){
    return http.get("/security/userBooks/{user_id}",userIds);
}