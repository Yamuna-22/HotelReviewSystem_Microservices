package com.hotelService.servicesImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelService.entities.Hotel;
import com.hotelService.repositories.HotelRepository;
import com.hotelService.services.HotelService;
import com.hotelService.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		//generate unique userId
        String randomUserId = UUID.randomUUID().toString();
        hotel.setId(randomUserId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll() ;
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with the gived id is not found on the server !!: " + id));
	}

}
