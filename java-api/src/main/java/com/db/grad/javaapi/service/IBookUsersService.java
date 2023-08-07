package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUsers;
import com.db.grad.javaapi.model.Books;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBookUsersService {
//    List<BookUsers> getAllBookUsers();
    Books getBookUsersById(String uniqueId);
//    BookUsers addBookUsers(BookUsers theBookUsers);
//    BookUsers updateBookUsersDetails(BookUsers bookDetails);
//    boolean removeBookUser(int id);

    List<String> getAllBookUsers(String bondholder);
}
