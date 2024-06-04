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
	
	@Override
	public List<Vuelo> vuelos() {
		return dao.findAll();
	}
	
	@Override
	public List<Vuelo> vuelosConSitioPasajeros(int plazasReservadas) {
		return dao.vuelosConSitioPasajeros(plazasReservadas);
	}

	@Override
	public void actualizaPlazasVuelo(int idVuelo, int plazasReservadas) {
		Vuelo vuelo = dao.findById(idVuelo).orElse(null);
		if(vuelo != null && vuelo.getPlazasDisponibles() >= plazasReservadas) {
			vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles()- plazasReservadas);
			dao.save(vuelo);
		}
	}



}
