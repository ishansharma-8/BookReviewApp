package com.Springboot.BookReviewApplication.controllers;
import java.util.List;
import java.util.Map;

import com.Springboot.BookReviewApplication.entities.Review;
import com.Springboot.BookReviewApplication.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @PostMapping("/saveReview")
    public ResponseEntity<Long> saveReview(@RequestBody Review review) {
        Long reviewId = bookService.saveReview(review);
        return ResponseEntity.ok(reviewId);
    }

    @GetMapping("/getReview")
   public ResponseEntity<List<Review>> getReviews(@RequestParam Long userId){
        return ResponseEntity.ok(bookService.getUserReviews(userId));
    }


}
