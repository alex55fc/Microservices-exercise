package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.VueloService;

@RestController
public class VueloController {
	
	@Autowired
	VueloService service;
	
	@GetMapping(value="vuelos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listaVuelos(){
		return service.vuelos();
	}
	
	@GetMapping(value="vuelos/{plazasReservadas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listaVuelosPlazasDisponibles(@PathVariable int plazasReservadas){
		return service.vuelosConSitioPasajeros(plazasReservadas);
	}
	
	@PutMapping(value="vuelos/{idVuelo}/{plazasReservadas}")
	public void actualizarPlazasVuelo(@PathVariable int idVuelo, @PathVariable int plazasReservadas) {
		service.actualizaPlazasVuelo(idVuelo, plazasReservadas);
	}
}
