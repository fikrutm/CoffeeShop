package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;


@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	
	@RequestMapping(value = "orders")
	public String getOrders(Model model) {
		List<Order> orders = orderService.findAll();
		model.addAttribute("orders", orders);
		return "ordersList";
	}

	
	@RequestMapping(value = "/{id}")
	public ModelAndView orderDetails(@PathVariable int id) {
		Order order = orderService.findById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("order", order);
		modelAndView.addObject("orderitems", order.getOrderLines());
		modelAndView.addObject("customer", order.getPerson());
		modelAndView.setViewName("orderDetail");
		return modelAndView;
	}

}
