package com.mastercraft.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mastercraft.entity.Product;
import com.mastercraft.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	public ProductRepository productRepository;

	public Product saveOrUpdateProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	public Product findById(int productId) {
		Optional<Product> optional = productRepository.findById(productId);

		if (optional.isPresent())
			return optional.get();

		return null;
	}

	public List<Product> findByName(String productName) {

		return productRepository.findByName(productName);

	}
}
