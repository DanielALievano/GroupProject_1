package edu.fiu.gt.shoppingcart;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoppingCartService {
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
    }
}
