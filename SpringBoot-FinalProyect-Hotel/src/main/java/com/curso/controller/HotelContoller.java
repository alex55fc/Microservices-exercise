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
	
    /**
     * Devuelve la lista de hoteles existentes en la base de datos.
     * 
     * @return una lista de objetos Hotel en formato JSON.
     */
	@GetMapping(value="hoteles", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles(){
		return service.hoteles();
	}
	
    /**
     * Devuelve los datos del hotel con el nombre especificado.
     * 
     * @param nomHotel El nombre del hotel del que se desea obtener los datos.
     * @return objeto Hotel con los datos del hotel especificado en formato JSON.
     */
	@GetMapping(value="hoteles/{nomHotel}", produces= MediaType.APPLICATION_JSON_VALUE)
	public Hotel datosHotel(@PathVariable String nomHotel) {
		return service.datosHotel(nomHotel);
	}
	
    /**
     * Verifica si existe un hotel con el ID especificado.
     * 
     * @param idHotel El ID del hotel que se desea verificar.
     * @return una cadena que representa true si el hotel existe, false de lo contrario.
     */
	@GetMapping(value="hoteles/id/{idHotel}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String idHotelExistente(@PathVariable int idHotel) {
		return String.valueOf(service.existsHotelId(idHotel)) ;
	}
	
    /**
     * Devuelve el ID del hotel con el nombre especificado.
     * 
     * @param nomHotel El nombre del hotel del que se desea obtener el ID.
     * @return una cadena que representa el ID del hotel especificado, o null si no se encuentra.
     */
	@GetMapping(value="hoteles/reserva/id/{nomHotel}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String devuelveIdHotelPorNombreHotel(@PathVariable String nomHotel) {
		return String.valueOf(service.devuelveIdHotelByNombreHotel(nomHotel));
	}
	
    /**
     * Verifica si existe un hotel con el nombre especificado.
     * 
     * @param nomHotel El nombre del hotel que se desea verificar.
     * @return una cadena que representa true si el hotel existe, false de lo contrario.
     */
	@GetMapping(value="hoteles/reserva/nombrehotel/{nomHotel}", produces= MediaType.TEXT_PLAIN_VALUE)
	public String nombreHotelExistente(@PathVariable String nomHotel) {
		return String.valueOf(service.existsHotelByName(nomHotel)) ;
	}
}
