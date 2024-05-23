package com.ratingService.services;

import java.util.List;

import com.ratingService.entities.Ratings;

public interface RatingService {
	
	//create 
	Ratings create (Ratings rating);
    //get all ratings	
	List<Ratings> getRatings();
	//get all by rating iD
	List<Ratings> getRatingsByUserId(String userId);
	//get all by hotel
	List<Ratings> getRatingsByHotelId(String hotelId);
	

}
