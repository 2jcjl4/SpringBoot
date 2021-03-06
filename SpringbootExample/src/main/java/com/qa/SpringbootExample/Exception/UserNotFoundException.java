package com.qa.SpringbootExample.Exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="User dead not exist with that ID")
public class UserNotFoundException extends NoSuchElementException {

	
	private static final long serialVersionUID = -5047783469011340873L;
}
