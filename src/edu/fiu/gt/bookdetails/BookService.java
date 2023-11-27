package edu.fiu.gt.bookdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fiu.gt.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // methods here (later)
}