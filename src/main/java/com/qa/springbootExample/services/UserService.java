package com.qa.springbootExample.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.springbootExample.domain.User;

@Service
public class UserService {

	// Temporary storage, until we implement real database
	private List<User> users = new ArrayList<>();

	public User create(User user) {
		users.add(user);
		return users.get(users.size() - 1);
	}

	public List<User> getAll() {
		return this.users;
	}

	public User getById(long id) {
		return users.get((int) id);
	}

	public User update(long id, User user) {
		users.remove((int) id);
		users.add((int) id, user);
		return users.get((int) id);
	}

	public User delete(int id) {
		return users.remove((int) id);
	}

}
