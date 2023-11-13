package edu.fiu.gt.bookbrowsingsorting;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "books")
public class Book{
@Id
@GeneratedValue
private long id;
@NotBlank
private String bookName;
@NotBlank
private String bookGenre;
@NotBlank
private double rating;
@NotBlank
private int copiesSold;
@NotBlank
private int price;
@NotBlank
public Book(){
    suoer();
}
public Book(Long id, String bookName, String bookGenre, double rating, int copiesSold, int price){
super();
this.id = id;
this.book_name = bookName;
this.book_genre = bookGenre;
this.rating = rating;
this.copiesSold = copiesSold;
this.price = price;
}
public Long getId(){
    return id;
}
public void setId(Long id) {
this.id = id;
}
public String getBookName(){
return bookName;
}
public void setBookName(String bookName) {
this.bookName = bookName;
}
public String getBookGenre(){
return bookGenre;
}
public void setBookGenre(String bookGenre) {
this.bookGenre = bookGenre;
}
public double getRating() {
return rating;
}
public void setRating(double rating){
    this.rating = rating;
}
public double getCopiesSold(){
return copiesSold;
}
public void setCopiesSold(int copiesSold){
    this.copiesSold = copiesSold;
}
public int getPrice(){
    return price;
}
public void setPrice(int price){
}
}