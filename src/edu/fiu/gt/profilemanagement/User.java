package edu.fiu.gt.profilemanagement;

import edu.fiu.gt.profilemanagement.exceptions.EmailAlreadyExistsException;
import edu.fiu.gt.profilemanagement.exceptions.InvalidPasswordException;
import edu.fiu.gt.profilemanagement.exceptions.UserNotFoundException;

import java.util.ArrayList;

/**
 * Represents a user of the Geek Text system
 *
 * @author Alvaro
 */

public class User {
    private final String username;
    private String password;
    private String email;
    private String fName;
    private String lName;
    private String address;
    private ArrayList<CreditCard> wallet;

    /**
     * Constructor with only required fields
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;

        wallet = new ArrayList<CreditCard>();
    }

    /**
     * Constructor with all possible fields but empty wallet
     *
     * @param username
     * @param password
     * @param email
     * @param fName
     * @param lName
     * @param address
     */
    public User(String username, String password, String email, String fName, String lName, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.address = address;

        wallet = new ArrayList<CreditCard>();
    }

    /**
     * Constructor with all possible fields and an existing wallet
     *
     * @param username
     * @param password
     * @param email
     * @param fName
     * @param lName
     * @param address
     * @param wallet
     */
    public User(String username, String password, String email, String fName, String lName, String address, ArrayList<CreditCard> wallet) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.wallet = wallet;
    }

    /**
     * Copy constructor
     *
     * @param user
     */
    public User(User user) {
        this(user.username, user.password, user.email, user.fName, user.lName, user.address, user.wallet);
    }

    public String getUsername() {
        return username;
    }

    /**
     * Sets user's password to newPassword if oldPassword matches user's password, throws an exception if it does not
     *
     * @param oldPassword
     * @param newPassword
     * @throws InvalidPasswordException
     */
    public void setPassword(String oldPassword, String newPassword) throws InvalidPasswordException {
        if(isValidPassword(oldPassword))
            this.password = newPassword;
        else
            throw new InvalidPasswordException("Invalid password for user " + this.username);
    }

    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email to the given String if it does not already exist, throws an exception if it does
     *
     * @param email
     */
    public void setEmail(String email) throws EmailAlreadyExistsException {
        if(this.email == null)
            this.email = email;
        else
            throw new EmailAlreadyExistsException("Email already exists for user " + this.username);
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    public String getFullName() {
        return fName + " " + lName;
    }

    public void setFullName(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Verifies whether the given password matches the user's
     *
     * @param password
     * @return isValidPassword
     */
    public boolean isValidPassword(String password) {
        return password.equals(this.password);
    }

    /**
     * Retrieves User object from list if it exists, throws an exception if it does not
     *
     * @param wantedUser
     * @param userList
     * @return user
     */
    public static User getUser(User wantedUser, ArrayList<User> userList) throws UserNotFoundException {
        // search for the wanted user by comparing it to every User in list
        for(User currentUser : userList) {
            if(currentUser.username.equals(wantedUser.username))
                return currentUser;
        }
        // if user is not found, throw an exception
        throw new UserNotFoundException("User " + wantedUser.username + " not found in given list.");
    }

    /**
     * Retrieves User object with given username from list if it exists, throws an exception if it does not
     *
     * @param wantedUserUsername
     * @param userList
     * @return user
     */
    public static User getUser(String wantedUserUsername, ArrayList<User> userList) throws UserNotFoundException {
        // search for the wanted user by comparing it to every User in list
        for(User currentUser : userList) {
            if(currentUser.username.equals(wantedUserUsername))
                return currentUser;
        }
        // if user is not found, throw an exception
        throw new UserNotFoundException("User " + wantedUserUsername + " not found in given list.");
    }

    /**
     * Adds a credit card to the user's wallet
     *
     * @param card
     */
    public void addCreditCard(CreditCard card) {
        wallet.add(card);
    }

    /**
     * Adds a credit card to the given user in the given list
     *
     * @param card
     * @param user
     * @param userList
     * @throws UserNotFoundException
     */
    public static void addCreditCard(CreditCard card, User user, ArrayList<User> userList) throws UserNotFoundException {
        for(User currentUser : userList) {
            if (currentUser.username.equals(user.username)) {
                currentUser.addCreditCard(card);
                return;
            }
        }

        throw new UserNotFoundException("User " + user.username + " not found in given list.");
    }

    /**
     * Adds a credit card to the User object with the given username in the given list
     *
     * @param card
     * @param username
     * @param userList
     * @throws UserNotFoundException
     */
    public static void addCreditCard(CreditCard card, String username, ArrayList<User> userList) throws UserNotFoundException {
        for(User currentUser : userList) {
            if (currentUser.username.equals(username)) {
                currentUser.addCreditCard(card);
                return;
            }
        }

        throw new UserNotFoundException("User " + username + " not found in given list.");
    }
}
