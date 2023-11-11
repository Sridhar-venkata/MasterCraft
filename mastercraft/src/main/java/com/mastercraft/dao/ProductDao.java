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

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public boolean deleteProduct(int id) {

		Optional<Product> optional = productRepository.findById(id);

		if (optional.isPresent()) {
			productRepository.delete(optional.get());
			return true;
		}
		return false;
	}

	public Product findById(int id) {
		Optional<Product> optional = productRepository.findById(id);

		if (optional.isPresent())
			return optional.get();

		return null;
	}

	public List<Product> findByName(String name) {

		return productRepository.findByName(name);

	}
}
