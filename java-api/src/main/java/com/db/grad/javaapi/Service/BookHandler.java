package com.db.grad.javaapi.Service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookHandler {

    private BookRepository bookRepository;

    @Autowired
    public BookHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book addBook(Book theBook) {
        return bookRepository.save(theBook);
    }


    public long getNoOfBooks() {
        return bookRepository.count();
    }


    public boolean removeBook(long uniqueId) {
        boolean result = false;

        Optional<Book> theBook = bookRepository.findById(uniqueId);
        if(theBook.isPresent())
        {
            bookRepository.delete(theBook.get());
            result = true;
        }

        return  result;
    }

    public Book getBookById(long uniqueId) {
        return bookRepository.findById(uniqueId).get();
    }

    public Book getBookByName(String BooksName) {
        Book BookToFind = new Book();
        BookToFind.setName(BooksName);
        List<Book> Books = bookRepository.findByName(BookToFind);
        Book result = null;

        if( Books.size() == 1)
            result = Books.get(0);

        return result;
    }


    public Book updateBookDetails(Book BookToUpdate) {
        return bookRepository.save(BookToUpdate);
    }

    public List<Book> getAllBooksByUserID(long id) {
        return bookRepository.getAllBooksByUserID(id);
    }
}
