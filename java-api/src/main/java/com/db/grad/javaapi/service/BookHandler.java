package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookHandler implements IBookService{
    private BooksRepository itsBooksRepo;

    @Autowired
    public BookHandler(BooksRepository BookRepo)
    {
        itsBooksRepo = BookRepo;
    }

    @Override
    public List<Book> getAllBooks() {
        return itsBooksRepo.findAll();
    }

    @Override
    public Book addBook(Book theBook) {
        return itsBooksRepo.save(theBook);
    }


    public Book getBookBySecurityID(long id){
        return itsBooksRepo.getBookBySecurityID(id);
    }
    @Override
    public boolean removeBook(long id)
    {
        boolean result = false;
        Optional<Book> theBook = Optional.ofNullable(itsBooksRepo.findById(id));
        if(theBook.isPresent())
        {
            itsBooksRepo.delete(theBook.get());
            result = true;
        }
        return  result;

    }
    @Override
    public Book getBookByID(long id)
    {
        return itsBooksRepo.findById(id);
    }

    @Override
    public Book updateBookDetails(Book BookToUpdate)
    {
        return itsBooksRepo.save( BookToUpdate );
    }
}