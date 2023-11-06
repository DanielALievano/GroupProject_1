package edu.fiu.gt.profilemanagement.exceptions;

/**
 * Thrown when the given password does not match the user's password
 *
 * @author Alvaro
 */
public class InvalidPasswordException extends Throwable {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
