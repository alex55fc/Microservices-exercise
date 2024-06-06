package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Reserva;

public interface ReservasDao extends JpaRepository<Reserva, Integer> {
	
	@Query("SELECT r FROM Reserva r where r.idHotel = :idHotel")
	List<Reserva> getHotelReservationsList(@Param("idHotel") int idHotel);
}


