package com.db.grad.javaapi.service;

import com.google.api.client.json.webtoken.JsonWebToken;

public interface UserService {
    String signIn(String email, String password);
}
