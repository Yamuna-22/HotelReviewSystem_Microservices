package com.userService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userService.entities.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {
 //declarative approach
 @GetMapping("/hotels/{hotelId}")
 Hotel getHotel(@PathVariable("hotelId") String hotelId ) ;
 	  

}
