package com.techelevator.dao;

import com.techelevator.model.Product;
import java.util.List;
import java.util.Optional;
public interface ProductDao {
    Product create(Product product);
    Optional<Product> findById(int id);
    List<Product> findAll();
    Product update(Product product);
    void delete(int id);
}
