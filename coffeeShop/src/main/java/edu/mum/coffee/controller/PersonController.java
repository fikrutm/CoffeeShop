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
	@GetMapping("/persons/manage")
	public String managePerson() {	//Product product
		
		return "personManagement";
	}
	
	/*@GetMapping("/person/profile")
	public String personProfile() {	//Product product
		return "personProfileAdd";
	}*/
	
	@PostMapping("/person/add/profile")
	public String AddPerson(Person person,Model model) {			
		personService.savePerson(person);
		model.addAttribute("person", person);	
		return "personAddSuccess";
	}	
	/*
	@GetMapping("/persons/list")
	public String personsList() {	
		
		return "personsList";
	}
*/
}
