package com.ratingService.Controllers;

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

import com.ratingService.entities.Ratings;
import com.ratingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	//create Rating
	public ResponseEntity<Ratings> create(@RequestBody Ratings ratings){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(ratings));
		
	}
	
	@GetMapping
	//get all
	public ResponseEntity<List<Ratings>> getAllRatings(@RequestBody Ratings ratings){
		return ResponseEntity.ok(ratingService.getRatings());
		
	} 
	
	@GetMapping("/users/{userId}")
    //get Rating by userId
	public ResponseEntity<List<Ratings>> getRatingsbyuserId( @PathVariable String userId){
		return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
		
	} 
	
	@GetMapping("/hotels/{hotelId}")
	//get Rating by hotelId
	public ResponseEntity<List<Ratings>> getRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
		
	} 
	
	
}
