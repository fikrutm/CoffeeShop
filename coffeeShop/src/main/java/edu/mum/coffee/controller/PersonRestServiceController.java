package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;

@RestController
public class PersonRestServiceController {

	@Autowired
	private PersonService personService;

	/**
	 * Create, List, Update person
	 * 
	 */

	
	/******** CREATE PERSON *********/
	@PostMapping(path = "/persons/add")
	public String addPerson(@RequestBody Person person) {
		personService.savePerson(person);
		return "OK";
	}

	/******** GET PERSON BY ID *********/
	@GetMapping(path = "/persons/{id}")
	public Person getPersons(@PathVariable Long id) {
		return personService.findById(id);
	}

	/******** GET LIST OF PERSONS by email *********/

	@GetMapping(path = "/persons")
	public List<Person> getPersons(@RequestParam("email") String email) {
		return personService.findByEmail(email);
	}

	/******** UPDATE A PERSON *********/
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updateCustomer(@PathVariable Long id, @RequestBody Person person) {

		person = personService.savePerson(person);

		if (null == person) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

}
