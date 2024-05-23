package com.ratingService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingService.entities.Ratings;
import com.ratingService.repositories.RatingRepository;
import com.ratingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private  RatingRepository ratingRepository;
	@Override
	public Ratings create(Ratings rating) {
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Ratings> getRatings() {
		return ratingRepository.findAll();

	}

	@Override
	public List<Ratings> getRatingsByUserId(String userId) {
		return ratingRepository.findByUserId( userId);
		
	}

	@Override
	public List<Ratings> getRatingsByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}

}
