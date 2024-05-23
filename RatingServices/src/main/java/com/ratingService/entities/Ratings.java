package com.ratingService.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document("user_ratings")
public class Ratings {
	
	@Id
	//mongo db autogenerates the id 
	private String ratingId;	
	 private String userId;	
	 private String hotelId;	
	 private int rating;	
	 private String remark;	
	

}
