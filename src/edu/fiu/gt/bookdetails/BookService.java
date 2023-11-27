package edu.fiu.gt.bookdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // Method to add a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Method to retrieve a book by ISBN
    public Optional<Book> getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn);
    }

    // Method to add an author
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Method to get books by an author
    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }
}