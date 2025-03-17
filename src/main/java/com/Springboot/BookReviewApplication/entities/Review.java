package com.Springboot.BookReviewApplication.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews") 
public class Review {

    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  
    private User user;

    private Long bookId;
    private String review;
    private int rating;

   
    public Review() {}

    
    public Review(User user, Long bookId, String review, int rating) {
        this.user = user;
        this.bookId = bookId;
        this.review = review;
        this.rating = rating;
    }

   
    public Long getId() {  
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {  
        return user;
    }

    public void setUser(User user) {  
        this.user = user;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
