package com.Springboot.BookReviewApplication.repositories;
import com.Springboot.BookReviewApplication.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByUserId(Long userId);

}
