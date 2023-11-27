package edu.fiu.gt.profilemanagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Represents a credit card that belongs to a User
 *
 * @author Alvaro
 */
@Entity
@Table(name="cards")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARDS_SEQ")
    @SequenceGenerator(name = "CARDS_SEQ", sequenceName = "CARDS_SEQ", allocationSize = 1)
    @Column(name="id")
    private Long id;
    @Column(name="number")
    private String number;
    @Column(name="securityCode")
    private String securityCode;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    @JsonBackReference
    private User userOwner;
    public CreditCard() {}

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
    public Long getid() {
        return id;
    }
    public void setid(Long id) {
        this.id = id;
    }
    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }
}
