package com.mastercraft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercraft.dto.ResponseStructure;
import com.mastercraft.entity.Order;
import com.mastercraft.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<Order>> saveOrder(@RequestParam int customerId, @RequestBody Order order){
		return orderService.saveOrder(customerId, order);
	}
	
	@DeleteMapping("/order")
	public ResponseEntity<ResponseStructure<Boolean>> deleteOrderById(@RequestParam int orderId){
		return orderService.deleteOrderById(orderId);
	}
	
	@GetMapping("/orderid/{id}")
	public ResponseEntity<ResponseStructure<Order>> findOrderById(@PathVariable int orderId){
		return orderService.findById(orderId);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<ResponseStructure<List<Order>>> findAllOrders(){
		return orderService.findAllOrders();
	}
}
