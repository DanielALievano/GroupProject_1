package edu.fiu.gt.bookratingcommenting;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Book class to represent a book
public class BookRatingCommenting {
    private String title;

    public BookRatingCommenting(String title2) {
    }

    public String Books(String title) {
        this.title = title;
        return title;
    }

    public String getTitle() {
        return title;
    }
}

// Rating class to represent a rating for a book
class Rating {
    private int rating;
    String userId;
    String bookTitle;
    private Date date;

    public Rating(int rating, String userId, String bookTitle) {
        this.rating = rating;
        this.userId = userId;
        this.bookTitle = bookTitle;
        this.date = new Date(); // Set the current date
    }

    public int getRating() {
        return rating;
    }
}

// Comment class to represent a comment for a book
class Comment {
    private String text;
    String userId;
    String bookTitle;
    private Date date;

    public Comment(String text, String userId, String bookTitle) {
        this.text = text;
        this.userId = userId;
        this.bookTitle = bookTitle;
        this.date = new Date(); // Set the current date
    }

    public String getText() {
        return text;
    }
}

// BookStore class to manage books, ratings, and comments
class BookStore {
    private List<BookRatingCommenting> books = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public void addBook(String title) {
        books.add(new BookRatingCommenting(title));
    }

    public void createRating(int rating, String userId, String bookTitle) {
        ratings.add(new Rating(rating, userId, bookTitle));
    }

    public void createComment(String text, String userId, String bookTitle) {
        comments.add(new Comment(text, userId, bookTitle));
    }

    public List<Rating> getRatingsForBook(String bookTitle) {
        List<Rating> bookRatings = new ArrayList<>();
        for (Rating rating : ratings) {
            if (rating.bookTitle.equals(bookTitle)) {
                bookRatings.add(rating);
            }
        }
        return bookRatings;
    }

    public List<Comment> getCommentsForBook(String bookTitle) {
        List<Comment> bookComments = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.bookTitle.equals(bookTitle)) {
                bookComments.add(comment);
            }
        }
        return bookComments;
    }

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        // Add books
        bookStore.addBook("Book 1");
        bookStore.addBook("Book 2");

        // Create ratings and comments
        bookStore.createRating(4, "User1", "Book 1");
        bookStore.createRating(5, "User2", "Book 1");
        bookStore.createComment("Great book!", "User1", "Book 1");
        bookStore.createComment("Enjoyed it!", "User2", "Book 1");

        // Retrieve ratings and comments for a book
        List<Rating> book1Ratings = bookStore.getRatingsForBook("Book 1");
        List<Comment> book1Comments = bookStore.getCommentsForBook("Book 1");

        // Display ratings and comments
        System.out.println("Ratings for Book 1:");
        for (Rating rating : book1Ratings) {
            System.out.println("Rating: " + rating.getRating() + " by " + rating.userId);
        }

        System.out.println("\nComments for Book 1:");
        for (Comment comment : book1Comments) {
            System.out.println("Comment: " + comment.getText() + " by " + comment.userId);
        }
    }
}

