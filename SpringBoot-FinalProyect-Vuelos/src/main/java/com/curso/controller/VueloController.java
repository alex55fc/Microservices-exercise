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
	
	/**
	 * Obtiene una lista de vuelos con la cantidad especificada de plazas disponibles.
	 * 
	 * @param plazasReservadas La cantidad de plazas a reservar.
	 * @return Una lista de objetos de tipo Vuelo en formato JSON.
	 */
	@GetMapping(value="vuelos/{plazasReservadas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listaVuelosPlazasDisponibles(@PathVariable int plazasReservadas){
		return service.vuelosConSitioPasajeros(plazasReservadas);
	}
	
	/**
	 * Actualiza el número de plazas disponibles de un vuelo.
	 * 
	 * @param idVuelo El ID del vuelo que se actualizará.
	 * @param plazasReservadas La cantidad de plazas que se reservarán.
	 */
	@PutMapping(value="vuelos/{idVuelo}/{plazasReservadas}")
	public void actualizarPlazasVuelo(@PathVariable int idVuelo, @PathVariable int plazasReservadas) {
		service.actualizaPlazasVuelo(idVuelo, plazasReservadas);
	}
	
	/**
	 * Verifica si un vuelo con el ID especificado existe.
	 * 
	 * @param idVuelo El ID del vuelo a verificar.
	 * @return true si existe un vuelo con el ID especificado, false de lo contrario.
	 */
	@GetMapping(value="vuelos/id/{idVuelo}", produces= MediaType.TEXT_PLAIN_VALUE)
	public String existeVueloId(@PathVariable int idVuelo) {
		return String.valueOf(service.existsVueloId(idVuelo));
	}
	
	/**
	 * Verifica si un vuelo con el ID especificado tiene suficientes plazas disponibles para realizar una reserva.
	 * 
	 * @param idVuelo El ID del vuelo a comprobar.
	 * @param plazasReservadas La cantidad de plazas que se desean reservar.
	 * @return true si el vuelo tiene al menos la cantidad justa de plazas disponibles, "false" en caso contrario.
	 */
	@GetMapping(value="vuelos/reservas/{idVuelo}/{plazasReservadas}", produces= MediaType.TEXT_PLAIN_VALUE)
	public String vueloTienePlazasSuficientes(@PathVariable int idVuelo, @PathVariable int plazasReservadas) {
		return String.valueOf(service.vueloTienePlazasSuficientes(idVuelo, plazasReservadas));
	}
}
