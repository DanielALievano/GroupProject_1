package edu.fiu.gt.profilemanagement;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    private UserService userService;
    private final CreditCardRepository repository;
    @Autowired
    public CreditCardService(CreditCardRepository repository) {
        this.repository = repository;
    }

    public List<CreditCard> getAllCreditCards() {
        return repository.findAll();
    }
    public CreditCard getCreditCardById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CreditCard addCreditCard(CreditCardRequest newCreditCardRequest) {
        return repository.save(toCreditCard(newCreditCardRequest));
    }

    private CreditCard toCreditCard(CreditCardRequest request) {
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(request.getNumber());
        creditCard.setSecurityCode(request.getSecurityCode());
        User user = userService.getUserById(request.getUserId());
        if(user == null) {
            throw new EntityNotFoundException("User " + request.getUserId() + " not found");
        } else {
            creditCard.setUserOwner(user);
        }
        return creditCard;
    }
}
