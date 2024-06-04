package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

public interface VueloService {
	
	List<Vuelo> vuelos();
	List<Vuelo> vuelosConSitioPasajeros(int plazasReservadas);
	void actualizaPlazasVuelo(int idvuelo, int plazasReservadas);
}
