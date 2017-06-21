package edu.mum.coffee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	private PersonService personService;
	/*@GetMapping({"/", "/index", "/home"})
	public String homePage() {
		return "home";
	}*/

	@PostMapping("/user")
	public String backToUser(){		
		return "redirect:/user";
	}

	@GetMapping({"/user"})
	public String userPage() {
		return "user";
	}
	
	
		
	@GetMapping({"/admin"})
	public String adminPage() {
		return "admin";
	}
	
	//person controller 
	@GetMapping("/person/profile")
	public String personProfile() {	//Product product
		return "personProfileAdd";
	}

	@GetMapping("/persons/list")
	public String personsList(Model model) {	

		model.addAttribute("persons", personService.getAll());
		
		return "personsList";
	}

	@PostMapping("/person/add/profile")
	public String AddPerson(Person person,Model model) {			
		personService.savePerson(person);
		model.addAttribute("person", person);	
		return "personAddSuccess";
	}	
	

	//user profile added
	
		@GetMapping("/user/profile")
	public String profile(Principal principal, Model model) {
		String userEmail = principal.getName();
		List<Person> persons = personService.findByEmail(userEmail);
		Person user = null;
		for (Person person : persons) {
			if (person.getEmail().equals(userEmail)) {
				user = person;
				break;
			}
		}

		model.addAttribute("person", user);

		return "profile";
	}

	
	
	
}
