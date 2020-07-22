package com.genpact.librarymanagement.service;

import com.genpact.librarymanagement.model.Book;
import com.genpact.librarymanagement.model.Library;
import com.genpact.librarymanagement.repository.BookRepository;
import com.genpact.librarymanagement.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    BookRepository bookRepository;

    public List<Library> getAll(){
        List<Library> List = libraryRepository.findAll();
        return List;
    }

    public List<Book> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }
}
