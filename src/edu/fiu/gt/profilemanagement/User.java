package edu.fiu.gt.profilemanagement;

import jakarta.persistence.*;

import java.util.List;

/**
 * Represents a user of the Geek Text system
 *
 * @author Alvaro
 */

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="fName")
    private String fName;
    @Column(name="lName")
    private String lName;
    @Column(name="address")
    private String address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy="userOwner")
    private List<CreditCard> creditCards;

    public User(){ }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getid() {
        return id;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }
}
