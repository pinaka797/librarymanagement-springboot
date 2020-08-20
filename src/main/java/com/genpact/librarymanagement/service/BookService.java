package com.genpact.librarymanagement.service;

import com.genpact.librarymanagement.exception.ResourceNotFoundException;
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
    
    
    public Book createBook(Book book) {
		return bookRepository.save(book);
	}
    
    
    public Book updateBook(Book book) throws ResourceNotFoundException {
		Optional<Book> BookDb = this.bookRepository.findById(book.getId());
		
		if(BookDb.isPresent()) {
			Book bookUpdate = BookDb.get();
			bookUpdate.setId(book.getId());
			bookUpdate.setTitle(book.getTitle());
			bookUpdate.setISBN(book.getISBN());
			bookUpdate.setAuthor(book.getAuthor());
			bookRepository.save(bookUpdate);
			return bookUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + book.getId());
		}		
	}
    
    
    public void deleteBook(long bookId) throws ResourceNotFoundException {
		Optional<Book> bookDb = this.bookRepository.findById(bookId);
		
		if(bookDb.isPresent()) {
			this.bookRepository.delete(bookDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + bookId);
		}
		
	}

}
