package edu.fiu.gt.profilemanagement.exceptions;

/**
 * Thrown when a user cannot be found in a given list
 *
 * @author Alvaro
 */
public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super(message);
    }
}
