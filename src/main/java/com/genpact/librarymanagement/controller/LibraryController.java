package com.genpact.librarymanagement.controller;

import com.genpact.librarymanagement.exception.ResourceNotFoundException;
import com.genpact.librarymanagement.model.Book;
import com.genpact.librarymanagement.model.Library;
import com.genpact.librarymanagement.service.BookService;
import com.genpact.librarymanagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/demoservice")
public class LibraryController {
    @Autowired
    BookService bookService;
    @Autowired
    LibraryService libraryService;

    @GetMapping(value="/books")
    public List<Book> getBook() {
        List<Book> bookList = bookService.getAllBooks();
        return bookList;
    }
    @GetMapping(value="/library")
    public List<Library> getLibrary() {
        List<Library> bookList = libraryService.getAll();
        return bookList;
    }
    
    @PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return ResponseEntity.ok().body(this.bookService.createBook(book));
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book) throws ResourceNotFoundException{
		book.setId(id);
		return ResponseEntity.ok().body(this.bookService.updateBook(book));
	}

	@DeleteMapping("/books/{id}")
	public HttpStatus deleteBook(@PathVariable long id) throws ResourceNotFoundException{
		this.bookService.deleteBook(id);
		return HttpStatus.OK;
	}
	
	
	@GetMapping("/books/{id}")
    public List<Book> getAllBooksInLibrary(@PathVariable(value = "id") Long bid)
            throws ResourceNotFoundException {
        List<Book> list = libraryService.getAllBooks();
        return list;
    }


    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bid)
            throws ResourceNotFoundException {
        Book book = bookService.findById(bid)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bid));
        return ResponseEntity.ok().body(book);
    }



}
