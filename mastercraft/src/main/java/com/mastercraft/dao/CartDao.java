package com.mastercraft.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mastercraft.entity.Cart;
import com.mastercraft.repository.CartRepository;

@Repository
public class CartDao {

	@Autowired
	private CartRepository cartRepository;

	public Cart saveOrUpdateCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart findCartById(int cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		return optional.isPresent() ? optional.get() : null;
	}

	public void deleteCart(Cart cart) {
		cartRepository.delete(cart);
	}
	
}
