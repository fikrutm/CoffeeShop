package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
public class ProductRestServiceController {

	@Autowired
	private ProductService productService;

	/**
	 * Create, List, Delete, Update products
	 * 
	 */

	/******** GET LIST OF PRODUCTS *********/

	@GetMapping(value = "/products", produces = "application/json")
	public List<Product> getAllProducts() {
		return productService.getAllProduct();
	}

	/******** CREATE A PRODUCT *********/

	@PostMapping(path = "/products/create", consumes = "application/json", produces = "application/json")
	public String addProduct(@RequestBody Product product) {
		productService.save(product);
		return "OK";
	}

	/******** DELETE A PRODUCT *********/
	@DeleteMapping(path = "/products/remove", consumes = { "application/xml",
			"application/json" }, produces = "application/json")
	public String removeProduct(@RequestBody Product product) {
		productService.delete(product);
		return "OK";
	}

	/******** UPDATE A PRODUCT *********/
	@PutMapping("/prouducts/{id}")
	public ResponseEntity<Product> updateCustomer(@PathVariable Long id, @RequestBody Product product) {

		product = productService.save(product); // if the product is not there
												// it will create one

		if (null == product) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
}
