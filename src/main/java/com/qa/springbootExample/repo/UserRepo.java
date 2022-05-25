package com.qa.springbootExample.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springbootExample.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	// Custom read by name
	//SELECT * FROM user WHERE firstname = ?1
	List<User> findByFirstName(String name);
	
}
