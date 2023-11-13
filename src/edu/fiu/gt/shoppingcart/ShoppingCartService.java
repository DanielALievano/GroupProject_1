package edu.fiu.gt.shoppingcart;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoppingCartService {

    // Calculate the subtotal for a given user's cart
    public double calculateSubtotalForUser(String userId) {
        // Logic to calculate subtotal
        return 0.0; // Replace with actual subtotal
    }

    // Add a book to a user's cart
    public void addBookToCart(String userId, String bookId) {
        // Logic to add book to the cart
    }

    // Get the list of books in a user's cart
    public List<Book> getBooksInUserCart(String userId) {
        // Logic to retrieve books
        return null; // Replace with actual book list
    }

    // Remove a book from a user's cart
    public void removeBookFromCart(String userId, String bookId) {
        // Logic to remove book from the cart
    }
}
