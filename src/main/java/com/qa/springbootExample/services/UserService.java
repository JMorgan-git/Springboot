package com.qa.springbootExample.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.springbootExample.domain.User;
import com.qa.springbootExample.repo.UserRepo;

@Service
public class UserService {
	
	private UserRepo repo;
	
	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	// Create
	public User create(User user) {
		return repo.saveAndFlush(user);
	}

	// Read all
	public List<User> getAll() {
		return repo.findAll();
	}

	// Read by id
	public User getById(long id) {
		return repo.findById(id).get();
	}

	// Update
	public User update(long id, User user) {
		User existing = repo.findById(id).get();
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setUserName(user.getUserName());
		return repo.saveAndFlush(existing);
	}

	// Delete
	public User delete(long id) {
		return null;
	}

}
