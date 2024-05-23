package com.hotelService.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotelService.exceptions.ResourceNotFoundException;


public class GlobalExceptionHandler {

	//we send both response status code and also data
		//whenever ResourceNotFoundException.class is called then this method will run i.e what is specified by exception handler annotation
		@ExceptionHandler (ResourceNotFoundException.class)
		public ResponseEntity<Map<String, Object>> notFoundHanlder(ResourceNotFoundException ex){
		    Map map = new HashMap();
		    map.put("message", ex.getMessage());
		    map.put("success", false);
		    map.put("status",HttpStatus.NOT_FOUND );
		    
			 return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}

}
