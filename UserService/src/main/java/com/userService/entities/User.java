 package com.userService.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="micro_users")
public class User {
  
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Id
	@Column(name="ID")
	private String userId;
	@Column(name="NAME", length=20)
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ABOUT")
	private String about;
	@Transient
	// we use transient to say dont store rating in DB
	 private List<Rating>  ratings= new ArrayList<>();
	
}
