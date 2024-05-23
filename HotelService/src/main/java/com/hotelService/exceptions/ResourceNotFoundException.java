package com.hotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		super("Resource not found on server !!");
	}
	
	//parameterized constructor
	
	public ResourceNotFoundException(String s) {
		super(s);
	
	}

}
