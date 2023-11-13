package com.mastercraft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mastercraft.dao.ProductDao;
import com.mastercraft.dao.ReviewDao;
import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Product;
import com.mastercraft.entity.Review;
import com.mastercraft.exception.NoSuchProductFoundException;
import com.mastercraft.exception.NoSuchReviewFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Review>> saveReview(int productId, Review review) {
		Product recievedproduct = productDao.findById(productId);
		if (recievedproduct != null) {
			Review recievedReview = reviewDao.saveOrUpdateReview(review);
			List<Review> reviews = recievedproduct.getReviews();
			reviews.add(recievedReview);
			recievedproduct.setReviews(reviews);
			productDao.saveOrUpdateProduct(recievedproduct);
			ResponseStructure<Review> responseStructure = new ResponseStructure<Review>(HttpStatus.CREATED.value(),"Success",recievedReview);
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.CREATED);

		} else {
			throw new NoSuchProductFoundException("Product Id : " + productId + " Is Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<Review>> updateReview(Review review) {
		Review recievedReview = reviewDao.findReviewById(review.getReviewId());
		if (recievedReview != null) {
			Review reviewData = reviewDao.saveOrUpdateReview(review);
			ResponseStructure<Review> responseStructure = new ResponseStructure<Review>(HttpStatus.OK.value(),"Updated Success",reviewData);
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoSuchReviewFoundException("Review Is Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<Review>> findReviewById(int reviewId) {
		Review recievedReview = reviewDao.findReviewById(reviewId);
		if (recievedReview != null) {
			ResponseStructure<Review> responseStructure = new ResponseStructure<Review>(HttpStatus.FOUND.value(),"Succes",recievedReview);
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchReviewFoundException("Review Id : " + reviewId + " Is Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<List<Review>>> findReviewsByProductId(int productId) {
		List<Review> reviews = reviewDao.findReviewsByProductId(productId);
		if (reviews != null || !reviews.isEmpty()) {
			ResponseStructure<List<Review>> responseStructure = new ResponseStructure<List<Review>>(HttpStatus.FOUND.value(),"Succes",reviews);
			return new ResponseEntity<ResponseStructure<List<Review>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchReviewFoundException("For Product id : " + productId + " No Reviews Found");
		}
	}

	public ResponseEntity<ResponseStructure<Review>> deleteReview(Review review) {
		Review recievedReview = reviewDao.findReviewById(review.getReviewId());
		if (recievedReview != null) {
			
			reviewDao.deleteReview(recievedReview);
			ResponseStructure<Review> responseStructure = new ResponseStructure<Review>(HttpStatus.NO_CONTENT.value(),"Deleted Succes",recievedReview);
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.NO_CONTENT);
		} else {
			throw new NoSuchReviewFoundException("Review Is Not Exist");
		}

	}

}
