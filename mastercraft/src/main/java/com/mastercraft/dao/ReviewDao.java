package com.mastercraft.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mastercraft.entity.Review;
import com.mastercraft.repository.ReviewRepository;
@Repository
public class ReviewDao {

	@Autowired
	ReviewRepository reviewRepository;

	public Review saveOrUpdateReview(Review review) {
		return reviewRepository.save(review);
	}

	public Review findReviewById(int reviewId) {
		Optional<Review> optional = reviewRepository.findById(reviewId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Review> findReviewsByProductId(int productId) {

		return reviewRepository.findByProductId(productId);
	}

	public void deleteReview(Review review) {
		reviewRepository.delete(review);

	}

}
