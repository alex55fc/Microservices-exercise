package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Vuelo;

public interface VueloDao extends JpaRepository<Vuelo, Integer> {
	
	@Query("SELECT v FROM Vuelo v WHERE v.plazasDisponibles >= :plazasReservadas")
	List<Vuelo> vuelosConSitioPasajeros(@Param("plazasReservadas")int plazasReservadas);

	
}

