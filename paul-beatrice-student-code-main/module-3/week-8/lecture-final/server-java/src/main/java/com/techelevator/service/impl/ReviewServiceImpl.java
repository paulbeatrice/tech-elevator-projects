package com.techelevator.service.impl;
import com.techelevator.dao.ReviewDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.Review;
import com.techelevator.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewDao reviewDao;

    @Autowired
    public ReviewServiceImpl(ReviewDao reviewDAO){
        this.reviewDao = reviewDAO;
    }

    @Override
    public Review createReview(Review review) {
        return reviewDao.create(review);
    }

    @Override
    public Review getReviewById(int id) {
        return reviewDao.findById(id)
                .orElseThrow(() -> new ServiceException("Review not found with id: " + id));
    }

    @Override
    public List<Review> getReviewsByProductId(int productId) {
        return reviewDao.findByProductId(productId);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewDao.findAll();
    }

    @Override
    public Review updateReview(Review review) {
        try {
            return reviewDao.update(review);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteReview(int id) {
        try {
            reviewDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
