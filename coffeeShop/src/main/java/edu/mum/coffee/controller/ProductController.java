package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@GetMapping("/persons/manage")
	public String managePerson() {	//Product product
		
		return "personManagement";
	}
	
	/*
	 * Product Management
	 */
	@GetMapping("/products/list")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "productList";
	}

	@GetMapping("/product/create")
	public String createProduct() {
		return "productAdd";
	}
	
	
	@GetMapping("/products/manage")
	public String ManageProducts() {
		return "productManagement";
	}
	
	
	@PostMapping("/product/create")
	public String addProduct(Product product) {
		productService.save(product);
		if (product.getProductName() != null) {
			return "productAddSuccess";
		}
		return "errorpage";

	}

	

	@GetMapping("/product/remove")
	public String removeProduct() {

		return "productRemove";
	}

	@PostMapping("/product/remove")
	public String DeleteProduct(int id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		productService.delete(product);
		return "removalSucess";
	}


	

}
