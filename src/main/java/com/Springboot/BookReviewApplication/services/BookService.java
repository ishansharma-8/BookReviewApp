package com.Springboot.BookReviewApplication.services;

import com.Springboot.BookReviewApplication.entities.Review;
import com.Springboot.BookReviewApplication.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    private final ReviewRepository reviewRepository;

    public BookService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }



    public long saveReview(Review review){
        return reviewRepository.save(review).getId();
    }

    public List<Review> getUserReviews(Long userId){
        return reviewRepository.findByUserId(userId);
    }

}
