package com.mastercraft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mastercraft.dao.OrderDao;
import com.mastercraft.dao.UserDao;
import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entities.Order;
import com.mastercraft.entities.User;
import com.mastercraft.exceptions.NoSuchOrderFoundException;
import com.mastercraft.exceptions.NoSuchUserFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderDao dao;

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Order>> saveOrder(Order order) {

		order = dao.saveOrder(order);

		ResponseStructure<Order> rs = new ResponseStructure<Order>(HttpStatus.CREATED.value(), "Success", order);

		return new ResponseEntity<ResponseStructure<Order>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteOrderById(int orderId) {
		return null;
	}

	public ResponseEntity<ResponseStructure<Order>> updateOrder(Order order) {
		order = dao.updateOrder(order);

		ResponseStructure<Order> rs = new ResponseStructure<Order>(HttpStatus.OK.value(), "Success", order);

		return new ResponseEntity<ResponseStructure<Order>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Order>> findById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<ResponseStructure<List<Order>>> findAllOrders() {

		List<Order> orders = dao.findAllOrders();

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