package com.genpact.librarymanagement.service;

import com.genpact.librarymanagement.model.Book;
import com.genpact.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public Optional<Book> findById(Long bid) {
        return bookRepository.findById(bid);
    }
}
