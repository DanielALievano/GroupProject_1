package edu.fiu.gt.profilemanagement;

/**
 * Represents a credit card that belongs to a User
 *
 * @author Alvaro
 */
public class CreditCard {
    private final String number;
    private final String securityCode;

    /**
     * Constructor with required fields
     *
     * @param number
     * @param securityCode
     */
    public CreditCard(String number, String securityCode) {
        this.number = number;
        this.securityCode = securityCode;
    }
}
