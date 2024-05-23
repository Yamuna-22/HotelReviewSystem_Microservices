package com.hotelService.services;

import java.util.List;

import com.hotelService.entities.Hotel;

public interface HotelService {
	
	//create Hotel
	Hotel create(Hotel hotel);
	
	//get all hotels
	List<Hotel> getAll();
	
	//get single hotel
	Hotel get(String id);

}
