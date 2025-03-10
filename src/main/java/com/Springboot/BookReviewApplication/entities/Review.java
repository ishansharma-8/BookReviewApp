package com.Springboot.BookReviewApplication.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews") // Ensure table name matches database
public class Review {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;

    private Long userId;

    private String review;

    private int rating;

    public Review() {}


    public Review(Long bookId, Long userId, String review, int rating) {
        this.bookId = bookId;
        this.userId = userId;
        this.review = review;
        this.rating = rating;
    }


    public Long getId() { return id; }
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}