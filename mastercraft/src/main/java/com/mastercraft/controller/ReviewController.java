package com.mastercraft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Review;
import com.mastercraft.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/{productId}")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@RequestBody Review review,@PathVariable int productId)
	{
		return reviewService.saveReview(productId, review);
	}
	@PutMapping("/update/review")
	public ResponseEntity<ResponseStructure<Review>> updateReview(@RequestBody Review review)
	{
		
		return reviewService.updateReview(review);
	}
	@GetMapping("/id/{reviewId}")
	public ResponseEntity<ResponseStructure<Review>> findReviewById(@PathVariable int reviewId)
	{
		return reviewService.findReviewById(reviewId);
	}
	@GetMapping("/product/{productId}")
	public ResponseEntity<ResponseStructure<List<Review>>> findReviewsByProductId(@PathVariable int productId)
	{
		return reviewService.findReviewsByProductId(productId);
	}
	@DeleteMapping("/delete/review")
	public ResponseEntity<ResponseStructure<Review>> deleteReview(@RequestBody Review review)
	{
		return reviewService.deleteReview(review);
	}
	
}
