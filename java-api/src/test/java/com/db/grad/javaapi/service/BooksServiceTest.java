package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BooksRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BooksServiceTest {

    @Autowired
    private BooksService booksService;

    @MockBean
    private BooksRepository booksRepository;

    @Test
    @DisplayName("Test getAllBooks")
    public void testGetAllBooks() {
        Book book1 = new Book();
        Book book2 = new Book();

        doReturn(Arrays.asList(book1, book2)).when(booksRepository).findAll();

        List<Book> books = booksService.getAllBooks();

        Assertions.assertEquals(2, books.size(), "EQUALS");
    }

}
