package com.qa.SpringbootExample.Exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundExceptionWithID extends EntityNotFoundException {

	// can do all this front end but this is for learning
	public UserNotFoundExceptionWithID(long id) {
		super("User does not exist with ID; " + id);
		
	}
	
	
}
