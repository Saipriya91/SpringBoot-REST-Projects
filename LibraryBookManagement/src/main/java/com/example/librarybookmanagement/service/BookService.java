
package com.example.librarybookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarybookmanagement.model.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getBookId() == id);
    }

    public Book updateAvailability(int id, boolean available) {
        Book book = getBookById(id);

        if (book != null) {
            book.setAvailable(available);
        }

        return book;
    }
}
