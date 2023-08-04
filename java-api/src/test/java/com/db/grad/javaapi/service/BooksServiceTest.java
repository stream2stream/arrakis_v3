package com.db.grad.javaapi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.doReturn;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BooksRepository;

@SpringBootTest
public class BooksServiceTest {

    @Autowired
    private BooksService service;

    @MockBean
    private BooksRepository repo;

    @Test
    void testGetAllBooks() {
        Book b1 = new Book();
        b1.setId(0);
        b1.setName("Samantha");
        Book b2 = new Book();
        b2.setId(1);
        b2.setName("Brion");

        doReturn(Arrays.asList(b1, b2)).when(repo).findAll();
        List<Book> books = service.getAllBooks();

        int expected = 2;
        int actual = books.size();

        assertEquals(expected, actual);
    }

    @Test
    void testGetBookById() {
        Book b1 = new Book();
        b1.setId(0);
        b1.setName("Samantha");
        Book b2 = new Book();
        b2.setId(1);
        b2.setName("Brion");

        doReturn(Optional.of(b2).when(repo).findById(1));
        
        Book actual = service.getBookById(1);
        Book expected = b2;

        assertEquals(expected, actual);
    }
}
