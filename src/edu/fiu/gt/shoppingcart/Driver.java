package edu.fiu.gt.shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingCartExample {
    public static void main(String[] args) {
        ShoppingCartService shoppingCartService = new ShoppingCartService();

        // Add a book to the shopping cart
        shoppingCartService.addBookToCart("user1", "book1");

        // Get the subtotal
        double subtotal = shoppingCartService.getSubtotal("user1");
        System.out.println("Subtotal: $" + subtotal);

        // Retrieve the list of books in the shopping cart
        List<Book> cartItems = shoppingCartService.getCartItems("user1");
        System.out.println("Cart Items: " + cartItems);

        // Delete a book from the shopping cart
        shoppingCartService.deleteBookFromCart("user1", "book1");
    }
}
