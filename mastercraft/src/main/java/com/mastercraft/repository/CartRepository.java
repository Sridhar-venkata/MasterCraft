package com.mastercraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastercraft.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
