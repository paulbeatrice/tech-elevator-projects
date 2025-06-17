package com.techelevator.dao.impl;

import com.techelevator.dao.ReviewDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public class JdbcReviewDao implements ReviewDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final class ReviewRowMapper implements RowMapper<Review> {
        @Override
        public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
            Review review = new Review();
            review.setId(rs.getInt("id"));
            review.setProductId(rs.getInt("product_id"));
            review.setReviewer(rs.getString("reviewer"));
            review.setTitle(rs.getString("title"));
            review.setReview(rs.getString("review"));
            review.setRating(rs.getInt("rating"));
            review.setFavorited(rs.getBoolean("favorited"));
            return review;
        }
    }

    @Override
    public Review create(Review review) {
        String sql = "INSERT INTO Review (product_id, reviewer, title, review, rating, favorited) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
        int id = jdbcTemplate.queryForObject(sql, new Object[]{
                review.getProductId(), review.getReviewer(), review.getTitle(),
                review.getReview(), review.getRating(), review.isFavorited()
        }, Integer.class);
        review.setId(id);
        return review;
    }

    @Override
    public Optional<Review> findById(int id) {
        String sql = "SELECT * FROM Review WHERE id = ?";
        List<Review> reviews = jdbcTemplate.query(sql, new Object[]{id}, new ReviewRowMapper());
        return reviews.isEmpty() ? Optional.empty() : Optional.of(reviews.get(0));
    }

    @Override
    public List<Review> findByProductId(int productId) {
        String sql = "SELECT * FROM Review WHERE product_id = ?";
        return jdbcTemplate.query(sql, new Object[]{productId}, new ReviewRowMapper());
    }

    @Override
    public List<Review> findAll() {
        String sql = "SELECT * FROM Review";
        return jdbcTemplate.query(sql, new ReviewRowMapper());
    }

    @Override
    public Review update(Review review) {
        String sql = "UPDATE Review SET product_id = ?, reviewer = ?, title = ?, review = ?, rating = ?, favorited = ? WHERE id = ?";
        int count = jdbcTemplate.update(sql,
                review.getProductId(), review.getReviewer(), review.getTitle(),
                review.getReview(), review.getRating(), review.isFavorited(), review.getId());
        if (count == 0) {
            throw new DaoException("Review not found with id: " + review.getId());
        }
        return review;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Review WHERE id = ?";
        int count = jdbcTemplate.update(sql, id);
        if (count == 0) {
            throw new DaoException("Review not found with id: " + id);
        }
    }
}
