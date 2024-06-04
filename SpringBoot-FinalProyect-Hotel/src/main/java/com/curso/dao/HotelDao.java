package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {
	
	@Query("SELECT h FROM Hotel h where h.nomHotel = :nomHotel")
	Hotel obtainHotelByHotelName(@Param("nomHotel") String  nomHotel);

}
