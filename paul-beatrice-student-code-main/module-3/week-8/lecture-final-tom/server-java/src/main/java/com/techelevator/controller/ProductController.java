package com.techelevator.controller;
import com.techelevator.model.Product;
import com.techelevator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin //any URL
//@CrossOrigin(origins = "http://example.com") //single specific URL
//@CrossOrigin(origins = {"http://example.com", "http://anotherdomain.com"}) //multiple specific URLs
@PreAuthorize("isAuthenticated()") // restricts all methods to authenticated users
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product created = productService.createProduct(product);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
        product.setId(id);
        Product updated = productService.updateProduct(product);
        return ResponseEntity.ok(updated);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
