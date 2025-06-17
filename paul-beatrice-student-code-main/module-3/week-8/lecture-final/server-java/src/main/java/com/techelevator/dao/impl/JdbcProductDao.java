package com.techelevator.dao.impl;

import com.techelevator.dao.ProductDao;
import com.techelevator.dao.ReviewDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Product;
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
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;
    private final ReviewDao reviewDao;

    @Autowired
    public JdbcProductDao(JdbcTemplate jdbcTemplate, ReviewDao reviewDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.reviewDao = reviewDao;
    }

    private static final class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            // Reviews will be set later using the reviewDao.
            return product;
        }
    }

    @Override
    public Product create(Product product) {
        String sql = "INSERT INTO Product (name, description) VALUES (?, ?) RETURNING id";
        int id = jdbcTemplate.queryForObject(sql, new Object[]{product.getName(), product.getDescription()}, Integer.class);
        product.setId(id);
        // Newly created product does not have reviews yet.
        product.setReviews(null);
        return product;
    }

    @Override
    public Optional<Product> findById(int id) {
        String sql = "SELECT * FROM Product WHERE id = ?";
        List<Product> products = jdbcTemplate.query(sql, new Object[]{id}, new ProductRowMapper());
        if (products.isEmpty()) {
            return Optional.empty();
        } else {
            Product product = products.get(0);
            // Populate the reviews property using ReviewDAO
            List<Review> reviews = reviewDao.findByProductId(product.getId());
            product.setReviews(reviews);
            return Optional.of(product);
        }
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM Product";
        List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper());
        // Populate reviews for each product
        for (Product product : products) {
            List<Review> reviews = reviewDao.findByProductId(product.getId());
            product.setReviews(reviews);
        }
        return products;
    }

    @Override
    public Product update(Product product) {
        String sql = "UPDATE Product SET name = ?, description = ? WHERE id = ?";
        int count = jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getId());
        if (count == 0) {
            throw new DaoException("Product not found with id: " + product.getId());
        }
        return product;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Product WHERE id = ?";
        int count = jdbcTemplate.update(sql, id);
        if (count == 0) {
            throw new DaoException("Product not found with id: " + id);
        }
    }
}
