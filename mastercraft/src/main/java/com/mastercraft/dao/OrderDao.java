package com.mastercraft.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mastercraft.entity.Order;
import com.mastercraft.repository.OrderRepository;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;

	public Order saveOrUpdateOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order findOrderById(int orderId) {
		Optional<Order> optional = orderRepository.findById(orderId);
		return optional.isPresent() ? optional.get() : null;
	}

	public List<Order> findOrderByUserId(int userId) {
		return orderRepository.findOrderByUserId(userId);
	}

	public List<Order> findAllOrder() {
		return orderRepository.findAll();
	}

	public void deleteOrder(Order order) {
		orderRepository.delete(order);
	}

	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

}
