package com.mastercraft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastercraft.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	
	@Query("SELECT p.reviews FROM Product p WHERE p.productId=?1")
	List<Review> findByProductId(int productId);

}
