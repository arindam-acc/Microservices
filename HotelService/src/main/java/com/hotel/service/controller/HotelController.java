package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.entities.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/v1/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		Hotel newHotel = hotelService.saveHotel(hotel);
		return new ResponseEntity<Hotel>(newHotel, HttpStatus.CREATED);
	}
	
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel hotel = hotelService.getHotel(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	@GetMapping("/getAllHotel")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotel = hotelService.allHotels();
		return new ResponseEntity<List<Hotel>>(hotel, HttpStatus.OK);
	}

}
