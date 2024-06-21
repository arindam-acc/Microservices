package com.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.repositories.HotelRepository;
import com.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found "+hotelId));
	}

	@Override
	public List<Hotel> allHotels() {
		return hotelRepo.findAll();
	}

}
