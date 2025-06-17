package com.techelevator.service.impl;
import com.techelevator.dao.ProductDao;
import com.techelevator.dao.ReviewDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.Product;
import com.techelevator.model.Review;
import com.techelevator.service.ProductService;
import com.techelevator.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDAO){
        this.productDao = productDAO;
    }

    @Override
    public Product createProduct(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.findById(id)
                .orElseThrow(() -> new ServiceException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            return productDao.update(product);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            productDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
