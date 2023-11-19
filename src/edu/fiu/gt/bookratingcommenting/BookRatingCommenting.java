package edu.fiu.gt.bookratingcommenting;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/books")
public class BookRatingCommenting {

    private final List<BookRatingCommenting> books = new ArrayList<>();
    private final List<Rating> ratings = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(BookRatingCommenting.class, args);
    }

    // Book class to represent a book
    private static class BookRatingCommenting {
        private String title;

        public String Books(String title) {
            this.title = title;
            return title;
        }

        public String getTitle() {
            return title;
        }
    }

    // Rating class to represent a rating for a book
    private static class Rating {
        private int rating;
        String userId;
        String bookTitle;
        private Date date;

        public int getRating() {
            return rating;
        }
    }

    // Comment class to represent a comment for a book
    private static class Comment {
        private String text;
        String userId;
        String bookTitle;
        private Date date;

        public String getText() {
            return text;
        }
    }

    @PostMapping("/rate")
    public void createRating(@RequestBody Rating rating) {
        ratings.add(rating);
    }

    @PostMapping("/comment")
    public void createComment(@RequestBody Comment comment) {
        comments.add(comment);
    }

    @GetMapping("/ratings/{bookTitle}")
    public List<Rating> getRatingsForBook(@PathVariable String bookTitle) {
        List<Rating> bookRatings = new ArrayList<>();
        for (Rating rating : ratings) {
            if (rating.bookTitle.equals(bookTitle)) {
                bookRatings.add(rating);
            }
        }
        return bookRatings;
    }

    @GetMapping("/comments/{bookTitle}")
    public List<Comment> getCommentsForBook(@PathVariable String bookTitle) {
        List<Comment> bookComments = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.bookTitle.equals(bookTitle)) {
                bookComments.add(comment);
            }
        }
        return bookComments;
    }
}

