package com.userService.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userService.entities.User;

@Service
public interface UserService {

	
	// user operations 
		//create 
	public	User saveUser(User user);
		//get all users 
	public	List<User> getAllUsers();
		//get single user of given userID
	public	User getUser(String userId);
}
