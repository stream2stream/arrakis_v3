import http from './axios.common';


export function login(credentials){
    return http.post("/users/login",credentials);
}