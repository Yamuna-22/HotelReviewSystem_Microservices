package com.hotelService.controlletrs;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/staffs")
@RestController
public class StaffController {

	@GetMapping
	public ResponseEntity<List<String>> getStaffs(){
		List<String> list= Arrays.asList("Ram", "Shaya", "Monsters");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
