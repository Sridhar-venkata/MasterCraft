package com.mastercraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Cart;
import com.mastercraft.service.CartService;

@RestController 
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/{customerId}")
	public ResponseEntity<ResponseStructure<Cart>> saveCart(@PathVariable int customerId,@RequestBody Cart cart)
	{
		return cartService.saveCart(customerId, cart);
	}
	
	@PostMapping("/add/{cartId}/{productId}")
	public ResponseEntity<ResponseStructure<Cart>> addProductToCart(@PathVariable int cartId,@PathVariable int productId)
	{
		return cartService.addProductToCart(cartId, productId);
	}
	@DeleteMapping("/delete/{cartId}/{productId}")
	public ResponseEntity<ResponseStructure<Cart>> deleteProductFromCart(@PathVariable int cartId,@PathVariable int productId)
	{
		return cartService.deleteProductFromCart(cartId, productId);
	}
	
}
