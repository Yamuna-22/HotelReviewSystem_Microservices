package com.userService.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource not found on server !!");
	}
	
	//parameterized constructor
	
	public ResourceNotFoundException(String message) {
		super(message);
	
	}
}
