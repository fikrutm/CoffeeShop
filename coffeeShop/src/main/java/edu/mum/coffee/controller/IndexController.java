package edu.mum.coffee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.service.ProductService;

@Controller
public class IndexController {
	@Autowired
	private ProductService productService;

	@GetMapping({ "/", "/index", "/home" })
	public String homePage(Model model) {

		/**
		 *  THIS SHOWS HOW TO CONSUME THE WEBSERVICE EXPOSED SERVICE METHODS
		 *  
		 */
		 
		@SuppressWarnings("unchecked")
		List<Product>  products = new  RestTemplate().getForObject("http://localhost:8080/products",
		  ArrayList.class); 
		model.addAttribute("products", products);
		 

		 
		//model.addAttribute("products", productService.getAllProduct());
		return "home";
	}

	@GetMapping({ "/secure" })
	public String securePage() {
		return "secure";
	}
	
	@GetMapping({"/error"})
	public String erroUrl(){
		return "error";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 @RequestMapping(value = "/registration", method = RequestMethod.GET)
	    public String registration(Model model) {
	        model.addAttribute("userForm", new User());

	        return "registration";
	    }

}
