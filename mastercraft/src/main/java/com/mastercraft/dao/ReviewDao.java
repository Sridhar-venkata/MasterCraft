package com.mastercraft.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercraft.entity.Review;
import com.mastercraft.repository.ReviewRepository;

public class ReviewDao {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	public Review saveReview(Review review)
	{
		return reviewRepository.save(review);
	}
	
	public Review updateReview(Review review)
	{
		return reviewRepository.save(review);
	}
	
	public Review findReviewById(int reviewId)
	{
		Optional<Review> optional=reviewRepository.findById(reviewId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public List<Review> findReviewsByProductId(int productId)
	{
		
		return reviewRepository.findByProductId(productId);
	}
	
	public void deleteReviewById(Review review)
	{
			reviewRepository.delete(review);	
		
	}

	
	
	

	
}
