package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;

public interface IUserService {
    User getByFirebaseUserId(String userId);
}
