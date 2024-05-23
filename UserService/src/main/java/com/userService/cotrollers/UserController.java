    package com.userService.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.entities.User;
import com.userService.services.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserService userService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		//we can also generate unique id in service also
		User user1= userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	 int retryCount=0;
	 
	@GetMapping("/{userId}")
//	@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod="ratingHotelFallback")
	//single user get
	@Retry(name="ratingHotelService",fallbackMethod="ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		logger.info("Get single user handle : Usercontroller");
		logger.info("Retry count: {}"+ retryCount);
		retryCount++;
		User user=userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	//create a fall back method that runs when hotel / rating service goes down
	
	public ResponseEntity<User> ratingHotelFallback (String userId, Exception ex){
		User user=User.builder()
				.email("dummy@gmail.com")
				.name("Dummy")
				.about("Creating dummy user for fallback as the server is down")
				.userId("12345")
				.build();
		
		
		return new ResponseEntity(user,HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping
	//get all users
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUser=userService.getAllUsers();
		return ResponseEntity.ok(allUser);
	}
	
}
