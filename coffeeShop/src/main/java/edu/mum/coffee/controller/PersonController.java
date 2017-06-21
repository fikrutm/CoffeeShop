package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;

public class PersonController {

	@Autowired
	private PersonService personService;
	@GetMapping("/customers/manage")
	public String manageCustomers(Product product) {	
		
		return "customerManagement";
	}
	
	@GetMapping("/customer/profile")
	public String customerProfile(Product product) {	
		return "customerProfileAdd";
	}
	
	@PostMapping("/customer/add/profile")
	public String AddCustomer(Person person,Model model) {			
		personService.savePerson(person);
		model.addAttribute("person", person);
		return "customerAddSuccess";
	}	
	
	@GetMapping("/customers/list")
	public String customersList() {	
		
		return "customersList";
	}

}
