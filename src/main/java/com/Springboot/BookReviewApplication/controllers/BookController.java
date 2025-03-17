package com.Springboot.BookReviewApplication.controllers;
import java.util.List;
import java.util.Map;

import com.Springboot.BookReviewApplication.entities.Review;
import com.Springboot.BookReviewApplication.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/reviews")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //  Save Review (User must exist)
    @PostMapping("/saveReview")
    public ResponseEntity<Long> saveReview(@RequestParam Long userId, @RequestBody Review review) {
        return ResponseEntity.ok(bookService.saveReview(userId, review));
    }

    //  Get Reviews by User ID
    @GetMapping("/getReview")
    public ResponseEntity<List<Review>> getReviews(@RequestParam Long userId) {
        return ResponseEntity.ok(bookService.getUserReviews(userId));
    }
}
