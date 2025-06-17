package com.techelevator.service;
import com.techelevator.model.Review;
import java.util.List;
public interface ReviewService {
    Review createReview(Review review);
    Review getReviewById(int id);
    List<Review> getReviewsByProductId(int productId);
    List<Review> getAllReviews();
    Review updateReview(Review review);
    void deleteReview(int id);

}
