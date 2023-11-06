package edu.fiu.gt.shoppingcart;

public class Book {
    private String id;
    private String title;
    private double price;

    // Default constructor
    public Book() {}

    // Parameterized constructor
    public Book(String id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    // Getter and Setter for `id`
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for `title`
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for `price`
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Optionally override `toString` for pretty printing
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    // Optionally, you can override `equals` and `hashCode` if you need to compare books or use them in collections that rely on these methods
}
