import http from './axios-common';

export function getUserFromEmail(email)
{
    return http.get("/users/email/"+email)
}

export function getAllSecurities(userId){
    return http.post("/security/userBooks/"+userId);
}

export function getIssuerNames(userId){
    return http.get("/security/security-issuer/"+userId);
}