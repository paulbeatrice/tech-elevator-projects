package com.techelevator.controller;
import com.techelevator.model.Review;
import com.techelevator.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import java.security.Principal;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()") // restricts all methods to authenticated users
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }


    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id){
        Review review = reviewService.getReviewById(id);
        return ResponseEntity.ok(review);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        Review created = reviewService.createReview(review);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable int id, @RequestBody Review review){
        review.setId(id);
        Review updated = reviewService.updateReview(review);
        return ResponseEntity.ok(updated);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable int id, Principal principal){

        // Capture the authenticated user's details
        String username = principal.getName();
        // You might log the deletion for auditing purposes
        System.out.println("User " + username + " requested deletion of review with id: " + id);

        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    // Override the class-level restriction for this method:
    @PreAuthorize("permitAll()")
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable int productId){
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }
}
