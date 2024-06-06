package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VueloDao;
import com.curso.model.Vuelo;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	VueloDao dao;
	
	/**
	 * Devuelve la lista de vuelos de la base de datos
	 * 
	 * @return lista de vuelos.
	 */
	@Override
	public List<Vuelo> vuelos() {
		return dao.findAll();
	}

	/**
	 * Devuelve la lista de los vuelos con la cantidad especificada de plazas disponibles
	 * 
	 * @param plazasReservadas la cantidad de plazas a reservar 
	 * @return lista de vuelos con la cantidad de plazas disponibles indicada o superior.
	 */
	@Override
	public List<Vuelo> vuelosConSitioPasajeros(int plazasReservadas) {
		return dao.vuelosConSitioPasajeros(plazasReservadas);
	}
	
	/**
	 * Actualiza el numero de plazas disponibles de un vuelo, restando las plazas reservadas.
	 * 
	 * @param idVuelo el ID del vuelo a verificar
	 * @param plazasReservadas el numero de plazas que se desea reservar
	 */
	@Override
	public void actualizaPlazasVuelo(int idVuelo, int plazasReservadas) {
		Vuelo vuelo = dao.findById(idVuelo).orElse(null);
		if(vuelo != null && vuelo.getPlazasDisponibles() >= plazasReservadas && plazasReservadas > 0 ) {
			vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles()- plazasReservadas);
			dao.save(vuelo);
		}
	}

	/**
	 * Verifica si un vuelo con el ID especificado existe en la base de datos
	 * 
	 * @param idVuelo el ID del vuelo a verificar
	 * @return true si existe un vuelo con el ID especificado, falso de lo contrario
	 */
	@Override
	public Boolean existsVueloId(int idVuelo) {
		return dao.findById(idVuelo).isPresent();
	}

	/**
	 * Verifica si un vuelo con el ID especificado tiene suficientes plazas disponibles para realizar una reserva.
	 *
	 * @param idVuelo El ID del vuelo a comprobar.
	 * @param plazasReservadas La cantidad de plazas que se desean reservar.
	 * @return true si el vuelo tiene al menos la cantidad justa de plazas disponibles y el número de plazas reservadas es mayor que 0, false en caso contrario.
	 */
	@Override
	public Boolean vueloTienePlazasSuficientes(int idVuelo, int plazasReservadas) {
	
		Vuelo vuelo = dao.findById(idVuelo).orElse(null);
		if(vuelo != null && vuelo.getPlazasDisponibles() >= plazasReservadas && plazasReservadas > 0) {
			return true;
		}
		else { 
			return false; 
		}

	}



}
