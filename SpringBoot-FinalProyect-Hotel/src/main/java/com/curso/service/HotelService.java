package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;

public interface HotelService {
	
	List<Hotel> hoteles();
	Hotel datosHotel(String  nomHotel);
}
