package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;
import com.curso.model.ReservaDto;

public interface ReservasService {
	
	void insertReserva(ReservaDto reservaDto);
	List<Reserva> listaReservasDeUnHotel(String nomHotel);

	
}
