package com.techelevator.dao;
import com.techelevator.model.Review;
import java.util.List;
import java.util.Optional;
public interface ReviewDao {

    Review create(Review review);
    Optional<Review> findById(int id);
    List<Review> findByProductId(int productId);
    List<Review> findAll();
    Review update(Review review);
    void delete(int id);
}
