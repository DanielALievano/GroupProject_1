package edu.fiu.gt.profilemanagement;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RESTful repository for CreditCard entities. Acts as an abstraction of the database.
 *
 * @author Alvaro
 */
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
