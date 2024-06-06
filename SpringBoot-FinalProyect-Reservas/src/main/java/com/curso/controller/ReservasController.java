package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Reserva;
import com.curso.model.ReservaDto;
import com.curso.service.ReservasService;

@RestController
public class ReservasController{
	
	@Autowired
	ReservasService service;
	
	@PostMapping(value="reservas", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void insertarReserva(@RequestBody ReservaDto reservaDto) {
		service.insertReserva(reservaDto);
	}
	
	@GetMapping(value="reservas/hotel/{nomHotel}", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> listaReservasDeUnHotel(@PathVariable String nomHotel){
		return service.listaReservasDeUnHotel(nomHotel);
	}
}
