package edu.fiu.gt.profilemanagement;

/**
 * Represents a Credit Card POST request. Decoupled from Credit Card due to userId needing to be separate
 *
 * @author Alvaro
 */
public class CreditCardRequest {
    private String number;
    private String securityCode;
    private Long userId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
