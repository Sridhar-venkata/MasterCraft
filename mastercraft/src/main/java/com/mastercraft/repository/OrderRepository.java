package com.mastercraft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mastercraft.entity.Order;

public interface OrderRepository extends JpaRepository<Order , Integer>{

	@Query("SELECT u.orders FROM User u WHERE u.id=:userId")
	List<Order> findOrderByUserId(int userId);
	
}
