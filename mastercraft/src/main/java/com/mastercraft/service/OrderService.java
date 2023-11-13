package com.mastercraft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mastercraft.dao.OrderDao;
import com.mastercraft.dao.UserDao;
import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Order;
import com.mastercraft.entity.User;
import com.mastercraft.exception.NoSuchOrderFoundException;
import com.mastercraft.exception.NoSuchUserFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Order>> saveOrder(Order order) {

		order = orderDao.saveOrUpdateOrder(order);

		ResponseStructure<Order> rs = new ResponseStructure<Order>(HttpStatus.CREATED.value(), "Success", order);

		return new ResponseEntity<ResponseStructure<Order>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteOrderById(int orderId) {
		Order order = orderDao.findOrderById(orderId);

		if (order == null)
			throw new NoSuchOrderFoundException("No orders placed yet");

		orderDao.deleteOrder(order);

		ResponseStructure<Boolean> rs = new ResponseStructure<>(HttpStatus.NO_CONTENT.value(), "Success", true);

		return new ResponseEntity<ResponseStructure<Boolean>>(rs, HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<ResponseStructure<Order>> findById(int orderId) {
		Order order = orderDao.findOrderById(orderId);

		if (order == null)
			throw new NoSuchOrderFoundException("No orders placed yet");

		orderDao.deleteOrder(order);

		ResponseStructure<Order> rs = new ResponseStructure<>(HttpStatus.OK.value(), "Success", order);

		return new ResponseEntity<ResponseStructure<Order>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Order>>> findAllOrders() {

		List<Order> orders = orderDao.findAllOrders();

		if (orders.isEmpty())
			throw new NoSuchOrderFoundException("No orders placed yet");

		ResponseStructure<List<Order>> rs = new ResponseStructure<List<Order>>(HttpStatus.OK.value(), "Success",
				orders);

		return new ResponseEntity<ResponseStructure<List<Order>>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Order>>> findByUserId(int userId) {

		User user = userDao.findUserById(userId);

		if (user == null)
			throw new NoSuchUserFoundException("Invalid User ID");

		List<Order> orders = user.getOrders();

		if (orders == null || orders.isEmpty())
			throw new NoSuchOrderFoundException("No orders placed yet");

		ResponseStructure<List<Order>> rs = new ResponseStructure<List<Order>>(HttpStatus.OK.value(), "Success",
				orders);

		return new ResponseEntity<ResponseStructure<List<Order>>>(rs, HttpStatus.OK);
	}
}