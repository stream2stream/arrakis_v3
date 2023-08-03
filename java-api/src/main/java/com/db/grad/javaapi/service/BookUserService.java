package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.repository.BookUserRepository;

import java.util.List;

public interface BookUserService {
    public List<BookUser> getAllBookUsers();
}
