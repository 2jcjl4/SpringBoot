package com.qa.SpringbootExample.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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

import com.qa.SpringbootExample.Services.UserService;
import com.qa.SpringbootExample.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	// Read --> get
	
	// Testing get method
//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello";
//	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getById(@PathVariable long id){
		return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getByFirstName/{name}")
	public ResponseEntity<List<User>> getByFirstName(@PathVariable String name){
		return new ResponseEntity<List<User>>(service.getByFirstName(name), HttpStatus.OK);
	}
	
	// Create --> post @PostMapping
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}
	// Update --> put/patch @PutMapping
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user){
		return new ResponseEntity<User>(service.update(id, user), HttpStatus.ACCEPTED);
	}
//	
//	@PutMapping("/updateWithParam")
//	public User updateWithParam(@PathParam("id") long id, @RequestBody User user){
//		//Remove original user
//		users.remove((int)id);
//		//Add the updated user
//		users.add((int)id,user);
//		//return the update for the user to see
//		return users.get((int)id);
//
//	}
//	
	
	// Delete --> Delete @DeleteMapping
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) { 
		return service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		//return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT);
	}
	
	
	
}
