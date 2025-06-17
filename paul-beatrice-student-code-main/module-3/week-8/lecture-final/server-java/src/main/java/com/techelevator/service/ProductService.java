package com.techelevator.service;
import com.techelevator.model.Product;
import java.util.List;
public interface ProductService {

    Product createProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    void deleteProduct(int id);
}
