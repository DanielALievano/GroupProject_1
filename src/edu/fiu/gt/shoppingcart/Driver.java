package edu.fiu.gt.shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
    private String bookId;
    private String title;
    private double price;

    public Book(String bookId, String title, double price) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

class ShoppingCartService {
    private Map<String, List<Book>> userCarts;

    public ShoppingCartService() {
        this.userCarts = new HashMap<>();
    }

    // Add a book to the shopping cart
    public void addBookToCart(String userId, String bookId) {
        // Assume a method getBookById is available to retrieve book details
        Book book = getBookById(bookId);

        if (book != null) {
            userCarts.computeIfAbsent(userId, k -> new ArrayList<>()).add(book);
        }
    }

    // Retrieve the subtotal price of all items in the user's shopping cart
    public double getSubtotal(String userId) {
        List<Book> cart = userCarts.getOrDefault(userId, new ArrayList<>());
        double subtotal = cart.stream().mapToDouble(Book::getPrice).sum();
        return subtotal;
    }

    // Retrieve the list of books in the user's shopping cart
    public List<Book> getCartItems(String userId) {
        return userCarts.getOrDefault(userId, new ArrayList<>());
    }

    // Delete a book from the shopping cart
    public void deleteBookFromCart(String userId, String bookId) {
        List<Book> cart = userCarts.getOrDefault(userId, new ArrayList<>());
        cart.removeIf(book -> book.getBookId().equals(bookId));
    }

    // Helper method to get book details (replace with your data retrieval logic)
    private Book getBookById(String bookId) {
        // Replace this with actual logic to fetch book details from your data source
        // For simplicity, I'm creating a dummy book here
        Book book = new Book();
        book.setBookId(bookId);
        book.setTitle("Dummy Book");
        book.setPrice(19.99);
        return book;
    }
}

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