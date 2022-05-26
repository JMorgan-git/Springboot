package com.qa.springbootExample.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.qa.springbootExample.domain.User;
import com.qa.springbootExample.repo.UserRepo;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepo repo;
	
	// Create Test
	@Test
	public void createTest() {
		User input = new User("Tim", "Brown", "tBrown1");
		User output = new User(1L, "Tim", "Brown", "tBrown1");
		
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, service.create(output));
		
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
	}

	// Read all Test
	@Test
	public void getAllTest() {
		List<User> output = new ArrayList<>();
		output.add(new User(1L, "Tim", "Brown", "tBrown1"));
		
		Mockito.when(repo.findAll()).thenReturn(output);
		
		assertEquals(output, service.getAll());
		
		Mockito.verify(repo, Mockito.times(1)).findAll();
	}

	// Read by id Test
	@Test
	public void getByIdTest() {
		//List<User> output = new ArrayList<>();
		//output.add(new User(1L, "Tim", "Brown", "tBrown1"));
		
		User output = new User(1L, "Tim", "Brown", "tBrown1");
		
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(output));
		
		assertEquals(output, service.getById(1L));
		
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}
	
	// Read by Name custom Test
	@Test
	public void getByFirstNameTest() {
		List<User> output = new ArrayList<>();
		output.add(new User(1L, "Tim", "Brown", "tBrown1"));
		
		Mockito.when(repo.findByFirstName("Tim")).thenReturn(output);
		
		assertEquals(output, service.getByFirstName("Tim"));
		
		Mockito.verify(repo, Mockito.times(1)).findByFirstName("Tim");
	}

	// Update Test
	@Test
	public void updateTest() {

		User input = new User("Dave", "Green", "dGreen1");
		Optional<User> existing = Optional.of(new User(1L, "Tim", "Brown", "tBrown1"));
		User output = new User(1L, "Dave", "Green", "dGreen1");
		
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, service.update(1L, input));
		
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
	}

	// Delete Test
	//@Disabled
	@Test
	public void deleteTest() {
		final long Id = 1L;
		Mockito.when(repo.existsById(Id)).thenReturn(true);
		
		assertEquals(true, service.delete(1L));
		
		Mockito.verify(repo, Mockito.times(1)).deleteById(Id);
	}

}
