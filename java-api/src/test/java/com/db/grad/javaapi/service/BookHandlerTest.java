package com.db.grad.javaapi.service;

import com.db.grad.javaapi.Service.BookHandler;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class BookHandlerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookHandler bookHandler;

    // create book method (id, name)
    private Book createBook(long id, String name) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        return book;
    }
    // create book method (name)
    private Book createBook(String name) {
        Book book = new Book();
        book.setName(name);
        return book;
    }
    @Test
    public void testGetAllBooks() {
        // Arrange
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(createBook(1L, "Trading_book_1"));
        expectedBooks.add(createBook(2L, "Trading_book_2"));
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookHandler.getAllBooks();

        // Assert
        assertEquals(expectedBooks.size(), actualBooks.size());
        for (int i = 0; i < expectedBooks.size(); i++) {
            Book expectedBook = expectedBooks.get(i);
            Book actualBook = actualBooks.get(i);
            assertEquals(expectedBook.getId(), actualBook.getId());
            assertEquals(expectedBook.getName(), actualBook.getName());
        }
    }
    @Test
    public void testAddBook() {
        // Arrange
        Book newBook = createBook("Trading_book_new");
        when(bookRepository.save(newBook)).thenReturn(newBook);

        // Act
        Book addedBook = bookHandler.addBook(newBook);

        // Assert
        assertEquals(newBook.getId(), addedBook.getId());
        assertEquals(newBook.getName(), addedBook.getName());
    }
    @Test
    public void testGetNoOfBooks() {
        // Arrange
        long expectedCount = 10;
        when(bookRepository.count()).thenReturn(expectedCount);

        // Act
        long actualCount = bookHandler.getNoOfBooks();

        // Assert
        assertEquals(expectedCount, actualCount);
    }
    @Test
    public void testRemoveBook_BookExists() {
        // Arrange
        long bookIdToRemove = 1L;
        Book bookToRemove = new Book();
        bookToRemove.setId(bookIdToRemove);
        when(bookRepository.findById(bookIdToRemove)).thenReturn(Optional.of(bookToRemove));

        // Act
        boolean result = bookHandler.removeBook(bookIdToRemove);

        // Assert
        assertTrue(result);
        verify(bookRepository).delete(bookToRemove);
    }

    @Test
    public void testRemoveBook_BookDoesNotExist() {
        // Arrange
        long bookIdToRemove = 1L;
        when(bookRepository.findById(bookIdToRemove)).thenReturn(Optional.empty());

        // Act
        boolean result = bookHandler.removeBook(bookIdToRemove);

        // Assert
        assertFalse(result);
        verify(bookRepository, never()).delete(any());
    }
    @Test
    public void testGetBookById_BookExists() {
        // Arrange
        long bookId = 1L;
        Book expectedBook = new Book();
        expectedBook.setId(bookId);
        expectedBook.setName("Trading_book_2");

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(expectedBook));

        // Act
        Book actualBook = bookHandler.getBookById(bookId);

        // Assert
        assertNotNull(actualBook);
        assertEquals(expectedBook.getId(), actualBook.getId());
        assertEquals(expectedBook.getName(), actualBook.getName());

    }

    @Test
    public void testGetBookById_BookDoesNotExist() {
        // Arrange
        long bookId = 1L;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        // Act
        Book actualBook = bookHandler.getBookById(bookId);

        // Assert
        assertNull(actualBook);
    }

    @Test
    public void testGetBookByName_BookExists() {
        // Arrange
        String bookName = "Trading_book_3";
        Book expectedBook = new Book();
        expectedBook.setId(1L);
        expectedBook.setName(bookName);

        List<Book> books = new ArrayList<>();
        books.add(expectedBook);
        when(bookRepository.findByName(any())).thenReturn(books);

        // Act
        Book actualBook = bookHandler.getBookByName(bookName);

        // Assert
        assertNotNull(actualBook);
        assertEquals(expectedBook.getId(), actualBook.getId());
        assertEquals(expectedBook.getName(), actualBook.getName());
    }

    @Test
    public void testGetBookByName_BookDoesNotExist() {
        // Arrange
        String bookName = "NotABook";
        when(bookRepository.findByName(any())).thenReturn(new ArrayList<>());

        // Act
        Book actualBook = bookHandler.getBookByName(bookName);

        // Assert
        assertNull(actualBook);
    }
    @Test
    public void testUpdateBookDetails() {
        // Arrange
        Book bookToUpdate = createBook(1L, "Trading_book_updated");
        when(bookRepository.save(bookToUpdate)).thenReturn(bookToUpdate);

        // Act
        Book updatedBook = bookHandler.updateBookDetails(bookToUpdate);

        // Assert
        assertNotNull(updatedBook);
        assertEquals(bookToUpdate.getId(), updatedBook.getId());
        assertEquals(bookToUpdate.getName(), updatedBook.getName());
    }

    @Test
    public void testGetAllBooksByUserID() {
        // Arrange
        long userId = 1L;
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(createBook(1L, "User_1_Book_1"));
        expectedBooks.add(createBook(2L, "User_1_Book_2"));
        when(bookRepository.getAllBooksByUserID(userId)).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookHandler.getAllBooksByUserID(userId);

        // Assert
        assertEquals(expectedBooks.size(), actualBooks.size());
        for (int i = 0; i < expectedBooks.size(); i++) {
            Book expectedBook = expectedBooks.get(i);
            Book actualBook = actualBooks.get(i);
            assertEquals(expectedBook.getId(), actualBook.getId());
            assertEquals(expectedBook.getName(), actualBook.getName());
        }
    }
}





