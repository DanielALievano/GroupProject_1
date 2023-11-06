package edu.fiu.gt.bookdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.fiu.gt.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}