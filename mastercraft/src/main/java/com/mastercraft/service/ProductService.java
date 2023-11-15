package com.mastercraft.service;

import java.util.List;

import org.apache.tomcat.websocket.ReadBufferOverflowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mastercraft.dao.ProductDao;
import com.mastercraft.dao.UserDao;
import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Product;
import com.mastercraft.entity.User;
import com.mastercraft.exception.NoSuchProductFoundException;
import com.mastercraft.exception.NoSuchUserFoundException;
import com.mastercraft.util.UserRole;

@Service
public class ProductService {

	@Autowired
	public ProductDao productDao;
	@Autowired
	public UserDao userDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(int userId,Product product) {
		User existingUser=userDao.findUserById(userId);
		
		if(existingUser!=null && existingUser.getRole().equals(UserRole.MERCHANT)) {
			productDao.saveOrUpdateProduct(product);
	
			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
	
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product);
	
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new NoSuchUserFoundException("No Such User Found with Id:"+userId);
		}

	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {
		int productId = product.getProductId();
		Product existingProduct = productDao.findById(productId);

		if (existingProduct != null) {
			product.setReviews(existingProduct.getReviews());
			productDao.saveOrUpdateProduct(product);

			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();

			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchProductFoundException("NO Such Product Found with id:" + productId);
		}

	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId) {
		Product product = productDao.findById(productId);
		if (product != null) {
			productDao.deleteProduct(product);

			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();

			responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.NO_CONTENT);
		} else {
			throw new NoSuchProductFoundException("NO Such Product Found with id:" + productId);
		}
	}

	public ResponseEntity<ResponseStructure<Product>> findById(int productId) {
		Product product = productDao.findById(productId);

		if (product != null) {

			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();

			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchProductFoundException("NO Such Product Found with id:" + productId);
		}
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findByName(String productName) {

		List<Product> product = productDao.findByName(productName);

		if (product != null) {

			ResponseStructure<List<Product>> responseStructure = new ResponseStructure<List<Product>>();

			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product);

			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchProductFoundException("NO Such Product Found with id:" + productName);
		}

	}
}
