package edu.fiu.gt.bookdetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // custom query methods if needed
}