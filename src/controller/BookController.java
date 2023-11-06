package com.Rest.API.controller;

import come.rest.API.exception.BookNotFoundException;
import com.restAPI.model.Book;
import com.rest.API.repository.BookRepository;
import com.org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

@Autowired
BookRepository bookRepository;

//get all notes
@GetMapping("/books")
public List<Book> getAllNotes(){

    return bookRepository.findAll();
}
    
//Create new note

@PostMapping("/books")
public book createNote(@Valid @RequestBody Book book){
    return bookRepository.save(book);

}

//Get a single note
@GetMapping("/book/{id}")
public Book Note(@PathVariable(value = "id") Long bookId) throws BookNotFoundException{
return bookRepository.findById(bookId)
.orElseThrow(()-> new BookNotFoundException(bookId));

}
// Update note
@PutMapping("/books.{id}")
public Book updateNote(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Book bookDetails) throws BookNotFoundException {

Book book = bookRepository.findById(bookId)
.orElseThrow(() -> new BookNotFoundException(bookId));

book.setBook_name(bookDetails.getBook_name());
        book.setAuthor_name(bookDetails.getAuthor_name());
        book.setIsbn(bookDetails.getIsbn());

Book updatedBook = bookRepository.save(book);

return updatedBook;
    }

// Delete a Note
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

bookRepository.delete(book);

return ResponseEntity.ok().build();
    }
}
