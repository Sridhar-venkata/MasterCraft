package com.mastercraft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Product;
import com.mastercraft.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	
	@PostMapping("/save/{userId}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(int userId,Product product) {
		
		return productService.saveProduct(userId, product);

	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {
		
		return productService.updateProduct(product);
		
	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId) {
		
		return productService.deleteProduct(productId);
		
	}

	@GetMapping("findById/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findById(int productId) {
		
		return productService.findById(productId);
		
	}

	@GetMapping("findByName/{productName}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByName(String productName) {
		
		return productService.findByName(productName);
		
	}

}
