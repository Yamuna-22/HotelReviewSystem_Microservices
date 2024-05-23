 package com.userService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userService.payLoad.ApiResponse;

//the below annotation , make this class a centralized exception handler
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	//we send both response status code and also data
	//whenever ResourceNotFoundException.class is called then this method will run i.e what is specified by exception handler annotation
	@ExceptionHandler (ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		 String message= ex.getMessage();
		 ApiResponse response = ApiResponse.builder()
				    .message(message)
				    .success(true)
				    .status(HttpStatus.NOT_FOUND)
				    .build();

//		 ApiResponse response= ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();   
		 return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}

}
 