
package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class BookUserHandler implements BookUserService {
    private BookUserRepository itsBookUserRepo;

    @Autowired
    public BookUserHandler( BookUserRepository bookUserRepo )
    {
        itsBookUserRepo = bookUserRepo;
    }

    @Override
    public List<BookUser> getAllBookUsers() {
        return itsBookUserRepo.findAll();
    }
}
