package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
static class Book {
        private String title;
        private String author;
        private String genre;
        private float price;
        private int stockQuantity;

        // Constructors, getters, and setters can be added here.
    }

    // Define a Rating class to store ratings and reviews for books
    static class Rating {
        private int stars;
        private String comment;

        // Constructors, getters, and setters can be added here.
    }

    // Define a Publisher class to represent book publishers
    static class Publisher {
        private String name;
        private int discountPercentage;

        // Constructors, getters, and setters can be added here.
    }

    // Define a class to manage the top ten best-sold books
    static class TenBestSold {
        private Book[] topBooks;

        // Methods for managing the top ten best-sold books can be added here.
    }
}