package com.mastercraft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mastercraft.dao.CartDao;
import com.mastercraft.dao.ProductDao;
import com.mastercraft.dao.UserDao;
import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Cart;
import com.mastercraft.entity.Product;
import com.mastercraft.entity.User;
import com.mastercraft.exception.NoSuchCartFoundException;
import com.mastercraft.exception.NoSuchProductFoundException;
import com.mastercraft.exception.NoSuchUserFoundException;

@Service
public class CartService 
{

	@Autowired
	UserDao userDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	ProductDao productDao;

	public ResponseEntity<ResponseStructure<Cart>> saveCart(int customerId, Cart cart) {
		User customer = userDao.findUserById(customerId);
		if (customer != null) {
			Cart cartData = cartDao.saveOrUpdateCart(cart);
			customer.setCart(cartData);
			userDao.saveOrUpdateUser(customer);
			ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>(HttpStatus.OK.value(),"Success",cartData);
			
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.CREATED);

		} else {
			throw new NoSuchUserFoundException("Customer Id :" + customerId + " Is Not Present");
		}
	}

	public ResponseEntity<ResponseStructure<Cart>> addProductToCart(int cartId, int productId) 
	{

		Cart cart = cartDao.findCartById(cartId);

		if (cart == null) {
			throw new NoSuchCartFoundException("Cart Id :" + cartId + " Is Not Present");
		}

		Product product = productDao.findById(productId);

		if (product != null) {
			
			List<Product> products = cart.getProducts();
			products.add(product);
			cartDao.saveOrUpdateCart(cart);
			ResponseStructure<Cart> responseStructure= new ResponseStructure<Cart>(HttpStatus.OK.value(),"Success",cart); 
			
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);
		} 
		else
			throw new NoSuchProductFoundException("Product Id :" + productId + " Is Not Present");

	}
	public ResponseEntity<ResponseStructure<Cart>> deleteProductFromCart(int cartId, int productId) 
	{
		Cart cart = cartDao.findCartById(cartId);

		if (cart == null) {
			throw new NoSuchCartFoundException("Cart Id :" + cartId + " Is Not Present");
		}

		Product product = productDao.findById(productId);

		if (product != null) {
			List<Product> products = cart.getProducts();
			products.remove(product);
			cartDao.saveOrUpdateCart(cart);
			ResponseStructure<Cart> responseStructure= new ResponseStructure<Cart>(HttpStatus.NO_CONTENT.value(),"Deleted Success",cart); 
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.NO_CONTENT);
		}
		else
			throw new NoSuchProductFoundException("Product Id :" + productId + " Is Not Present");
	}

	
}
