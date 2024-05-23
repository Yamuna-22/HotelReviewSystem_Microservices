package com.userService.entities;

import org.springframework.http.HttpStatus;

import com.userService.payLoad.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
 private String ratingId;	
 private String userId;	
 private String hotelId;	
 private int rating;	
 private String remark;	
 private Hotel hotel;	

}
