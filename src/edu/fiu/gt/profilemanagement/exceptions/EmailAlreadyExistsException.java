package edu.fiu.gt.profilemanagement.exceptions;

/**
 * Thrown when attempting to change the email of a user that already has one set
 *
 * @author Alvaro
 */
public class EmailAlreadyExistsException extends Throwable {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
