package bookdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByAuthorId(Long authorId); // Method to find books by the author's ID
}