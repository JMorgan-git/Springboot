package com.qa.springbootExample.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootExample.domain.User;
import com.qa.springbootExample.services.UserService;

@RestController
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	// Create - Post Request
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	//read all
	@GetMapping("/getAll")
	public List<User> getAll() {
		return service.getAll();
	}
	
	//read by id
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable long id) {
		return service.getById(id);
	}

	// Update - Put/Patch Request
    @PutMapping("/update/{id}")
    public User update(@PathVariable long id, @RequestBody User user) {
    	return service.update(id, user);
    }

	// Delete - Delete Request
    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable int id) {
    	return service.delete(id);
    }

}
