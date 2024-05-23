package com.ratingService.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratingService.entities.Ratings;

public interface RatingRepository extends MongoRepository<Ratings, String>{
  //custom finder method 
	
	List<Ratings> findByUserId(String userId);
	List<Ratings> findByHotelId(String hotelId);
	
	
	
}
