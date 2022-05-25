package com.qa.SpringbootExample.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.SpringbootExample.domain.User;

@Service
public class UserService {

	// Temp storage, until the real database is implemeted 
	private List<User> users = new ArrayList<>();
	

	public List<User> getAll(){
		return users;
	}
	

	public User getById(long id){
		return users.get((int)id);
	}
	

	public User create(User user) {
		user.setId(users.size()+1);
		users.add(user);
		return users.get(users.size()-1);
	}

	
	public User update(long id, User user){
		//Remove original user
		users.remove((int)id);
		//Add the updated user
		users.add((int)id,user);
		//return the update for the user to see
		return users.get((int)id);

	}


	public User delete(long id) { 
		return users.remove((int)id);
	}



	
}
