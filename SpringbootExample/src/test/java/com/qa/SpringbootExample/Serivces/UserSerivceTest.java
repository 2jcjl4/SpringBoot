package com.qa.SpringbootExample.Serivces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.SpringbootExample.Services.UserService;
import com.qa.SpringbootExample.controllers.UserController;
import com.qa.SpringbootExample.domain.User;
import com.qa.SpringbootExample.repo.UserRepo;

@SpringBootTest
public class UserSerivceTest {
	@Autowired
	private UserService service;
	
	@MockBean UserRepo repo;
	
	
	
	
	@Test
	public void getAllTest() {
		List<User> output = new ArrayList<>();
		output.add(new User(1L,"Tom","Jones","Tjones1"));
		
		Mockito.when(repo.findAll()).thenReturn(output);
		
		assertEquals(output, service.getAll());
		
		Mockito.verify(repo, Mockito.times(1)).findAll();
	}
	

	@Test
	public void getByIdTest() {
		List<User> output = new ArrayList<>();
		output.add(new User(1L,"Tom","Jones","Tjones1"));
		output.add(new User(2L,"james","long","JLong1"));
		
		Optional<User> optionalOutput = Optional.of(output);
		
		Mockito.when(repo.findById(1L)).thenReturn(optionalOutput);
		
		assertEquals(output,service.getById(1L));
		
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
		
		// MY ATTTEMPT WHATS THE DIF
//		Mockito.when(repo.findById(1L)).thenReturn(output);
//		
//		assertEquals(output, service.getById(1L));
//		
//		Mockito.verify(repo, Mockito.times(1)).findAll();
//		
	}
	
	@Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott", U_NAME = "Bscott1";
		final User created = new User(F_NAME, L_NAME, U_NAME);

		Mockito.when(repo.saveAndFlush(created)).thenReturn(created);

		assertEquals(created, service.create(created));

		Mockito.verify(repo, Mockito.times(1)).create(created);
	}

}
