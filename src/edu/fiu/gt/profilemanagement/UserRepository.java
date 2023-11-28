package edu.fiu.gt.profilemanagement;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RESTful repository for User entities. Acts as an abstraction of the database.
 *
 * @author Alvaro
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
