package com.hotelService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="micro_hotels")
public class Hotel {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;

}
