package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@RestController
public class OrderRestServiceController {

	@Autowired
	private OrderService orderService;

	/**
	 * Create, List order
	 * 
	 */

	/******** GET LIST OF ORDERS *********/

	@GetMapping("/orders")
	public List<Order> getOrders() {
		return orderService.findAll();
	}
	
	/******** CREATE LIST OF ORDER*********/

	@PostMapping("/orders/add")
	public String addOrder(@RequestBody Order order) {
		orderService.save(order);
		return "ok";
	}

}
