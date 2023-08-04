import http from './axios.common';


export function checkUser(user){
    return http.post("/users/login",user);
    //return http.get("/users");
}