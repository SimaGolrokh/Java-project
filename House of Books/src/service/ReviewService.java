package service;

import model.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewService {
    public List<Review> reviews = new ArrayList<>();
    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviewsByUser(String username) {
        return reviews.stream()
                .filter(review->review.getUser().getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public List<Review> getReviewsByBook(String ISBN){
        return reviews.stream()
                .filter(review ->review.getBook().getISBN().equals(ISBN))
                .collect(Collectors.toList());
    }

}
