package com.qa.springbootExample.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootExample.domain.User;
import com.qa.springbootExample.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	// Create - Post Request
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user),HttpStatus.CREATED);
	}

	// read all
	@GetMapping("/getAll")
	public ResponseEntity<List<User> >getAll() {
		return new ResponseEntity<List<User>>(service.getAll(),HttpStatus.OK);
	}

	// read by id
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getById(@PathVariable long id) {
		return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
	}
	
	// read by name
	@GetMapping("/getByFirstName/{name}")
	public ResponseEntity<List<User>> getByFirstName(@PathVariable String name) {
		return new ResponseEntity<List<User>>(service.getByFirstName(name), HttpStatus.OK);
	}

	// Update - Put/Patch Request
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
		return new ResponseEntity<User>(service.update(id, user), HttpStatus.ACCEPTED);
	}

	// Delete - Delete Request
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT);
	}

}
