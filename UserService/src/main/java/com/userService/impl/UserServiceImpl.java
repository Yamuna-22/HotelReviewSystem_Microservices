 package com.userService.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.entities.Hotel;
import com.userService.entities.Rating;
import com.userService.entities.User;
import com.userService.exceptions.ResourceNotFoundException;
import com.userService.external.services.HotelService;
import com.userService.repositories.UserRepository;
import com.userService.services.UserService;


@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private  HotelService hotelService;
	
	
	
	//one of the way to call the HTTP api from the microservices is to use the Rest API
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		//generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}
  
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override 
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		//get user from user database using UserRepository
		 User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with the gived id is not found on the server !!: " + userId));
		 //fetch rating of the above user from Rating service
		 Rating[] ratingsOfUser=restTemplate.getForObject("http://RATINGSERVICES/ratings/users/"+user.getUserId(), Rating[].class);
		 logger.info("{} ",ratingsOfUser); 
		 
		 List<Rating> ratings =Arrays.stream(ratingsOfUser).toList();
		
		 List<Rating> ratingList =ratings.stream().map(rating ->{
				/* 
				 * below is code for hhtp request using feign client
				 * //api call to hotel service to get the hotel
				 * System.out.println(rating.getHoteId()); ResponseEntity<Hotel> forEntity=
				 * restTemplate.getForEntity(
				 * "http://HOTELSERVICE/hotels/c9d1f63b-725d-4485-b957-74f759a09e90",Hotel.class
				 * ); Hotel hotel=forEntity.getBody();
				 *     
				 * logger.info("response status code: {} ", forEntity.getStatusCode()); //set
				 * the hotel to rating
				 * 
				 * rating.setHotel(hotel); //return the rating 
				 * return rating;
				 */
			 
			 Hotel hotel= hotelService.getHotel(rating.getHotelId());
			 rating.setHotel(hotel);
			 return rating;
			 
		 }).collect(Collectors.toList());
		 
   	     user.setRatings(ratingList);
		 return user;
	}
	

}
