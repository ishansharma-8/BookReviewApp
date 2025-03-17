package com.Springboot.BookReviewApplication.services;

import com.Springboot.BookReviewApplication.entities.Review;
import com.Springboot.BookReviewApplication.entities.User;
import com.Springboot.BookReviewApplication.repositories.ReviewRepository;
import com.Springboot.BookReviewApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookService(ReviewRepository reviewRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    //  Save Review (Ensure User Exists)
    public Long saveReview(Long userId, Review review) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        review.setUser(user);
        return reviewRepository.save(review).getId();
    }

    //  Get Reviews by User ID
    public List<Review> getUserReviews(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
}