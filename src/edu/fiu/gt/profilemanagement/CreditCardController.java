package edu.fiu.gt.profilemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful controller for the CreditCard entity. Handles Get and Post requests.
 *
 * @author Alvaro
 */
@RestController
@RequestMapping("/cards")
public class CreditCardController {
    private final CreditCardService service;
    @Autowired
    public CreditCardController(CreditCardService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        List<CreditCard> creditCardList = service.getAllCreditCards();
        if(creditCardList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(creditCardList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
        CreditCard creditCard = service.getCreditCardById(id);
        if(creditCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(creditCard, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCardRequest newCreditCard) {
        CreditCard creditCard = service.addCreditCard(newCreditCard);
        return new ResponseEntity<>(creditCard, HttpStatus.CREATED);
    }
}
