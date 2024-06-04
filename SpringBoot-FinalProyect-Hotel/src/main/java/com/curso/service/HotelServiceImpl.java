package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelDao;
import com.curso.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired 
	HotelDao dao;
	
	@Override
	public List<Hotel> hoteles() {
		return dao.findAll();
	}

	@Override
	public Hotel datosHotel(String nomHotel) {
		return dao.obtainHotelByHotelName(nomHotel);
	}

}
