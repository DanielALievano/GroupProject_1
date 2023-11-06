package edu.fiu.gt.shoppingcart;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    // Retrieve the subtotal price of all items in the user’s shopping cart.
    @GetMapping("/subtotal")
    public ResponseEntity<Double> getCartSubtotal(@RequestParam("userId") String userId) {
        double subtotal = shoppingCartService.calculateSubtotalForUser(userId);
        return ResponseEntity.ok(subtotal);
    }

    // Add a book to the shopping cart.
    @PostMapping("/add")
    public ResponseEntity<Void> addBookToCart(
            @RequestParam("userId") String userId,
            @RequestParam("bookId") String bookId) {
        shoppingCartService.addBookToCart(userId, bookId);
        return ResponseEntity.ok().build();
    }

    // Retrieve the list of book(s) in the user’s shopping cart.
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooksInCart(@RequestParam("userId") String userId) {
        List<Book> books = shoppingCartService.getBooksInUserCart(userId);
        return ResponseEntity.ok(books);
    }

    // Delete a book from the shopping cart instance for that user.
    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeBookFromCart(
            @RequestParam("userId") String userId,
            @RequestParam("bookId") String bookId) {
        shoppingCartService.removeBookFromCart(userId, bookId);
        return ResponseEntity.ok().build();
    }
}
