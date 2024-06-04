package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

@RestController
public class HotelContoller {
	
	@Autowired
	HotelService service;
	
	@GetMapping(value="hoteles", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles(){
		return service.hoteles();
	}
	
	@GetMapping(value="hoteles/{nomHotel}", produces= MediaType.APPLICATION_JSON_VALUE)
	public Hotel datosHotel(@PathVariable String nomHotel) {
		return service.datosHotel(nomHotel);
	}
	
}
