package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.ReservasDao;
import com.curso.model.Reserva;
import com.curso.model.ReservaDto;

@Service
public class ReservasServiceImpl implements ReservasService {

	@Autowired
	ReservasDao dao;
	
	@Autowired
	RestTemplate restTemplate;
	
	private final static String urlHotel="http://localhost:8080";
	private final static String urlVuelos="http://localhost:8081";

	/**
	 * Inserta una nueva reserva después de verificar si el hotel y el vuelo asociados
	 *  existen y si hay suficientes plazas disponibles en el vuelo.
	 * 
	 * @param reservaDto contiene los detalles necesarios para la reserva.
	 */
	@Override
	public void insertReserva(ReservaDto reservaDto) {	
		Reserva reserva = new Reserva(reservaDto.getNombreCliente(), reservaDto.getDni(), reservaDto.getIdHotel(), reservaDto.getIdVuelo());
		if(existeHotelConId(reservaDto.getIdHotel())) {
			if(existeVueloConId(reservaDto.getIdVuelo())) {
				if(plazasReservadasEnVuelo(reservaDto.getIdVuelo(), reservaDto.getPlazasReservadas())) {
					actualizarPlazasReservadasVuelo(reservaDto.getIdVuelo(), reservaDto.getPlazasReservadas());
					dao.save(reserva);
				}
				else {
					System.out.println("No es posible hacer la reserva con esa capacidad");
				}
			}
			else {
				System.out.println("Vuelo con ese id no encontrado");
			}
		}
		else {
			System.out.println("Hotel con ese id no encontrado");
		}
	}
	
	/**
	 * Verifica si existe un hotel con el ID especificado.
	 * 
	 * @param idHotel El ID del hotel a verificar.
	 * @return true si existe un hotel con el ID especificado, false de lo contrario.
	 */
	private Boolean existeHotelConId(int idHotel) {
		return Boolean.parseBoolean(restTemplate.getForObject(urlHotel + "/hoteles/id/{idHotel}", String.class, idHotel)) ; 
	}

	/**
	 * Verifica si existe un vuelo con el ID especificado.
	 * 
	 * @param idVuelo El ID del vuelo a verificar.
	 * @return true si existe un vuelo con el ID especificado, false de lo contrario.
	 */
	private Boolean existeVueloConId(int idVuelo) {
		return Boolean.parseBoolean(restTemplate.getForObject(urlVuelos + "/vuelos/id/{idVuelo}", String.class, idVuelo)) ;	 
	}
	
	/**
	 * Verifica si un vuelo con el ID especificado tiene suficientes plazas disponibles para realizar una reserva.
	 * 
	 * @param idVuelo El ID del vuelo a comprobar.
	 * @param plazasReservadas La cantidad de plazas a reservar.
	 * @return true si el vuelo tiene al menos la cantidad justa de plazas disponibles y el número de plazas reservadas es mayor que 0, false en caso contrario.
	 */
	private Boolean plazasReservadasEnVuelo(int idVuelo, int plazasReservadas) {
		return Boolean.parseBoolean(restTemplate.getForObject(urlVuelos + "/vuelos/reservas/{idVuelo}/{plazasReservadas}", String.class, idVuelo, plazasReservadas));
	}
	
	/**
	 * Actualiza el número de plazas disponibles de un vuelo.
	 * 
	 * @param idVuelo El ID del vuelo que se actualizará.
	 * @param plazasReservadas La cantidad de plazas que se reservarán.
	 */
	private void actualizarPlazasReservadasVuelo(int idVuelo, int plazasReservadas) {
		restTemplate.put(urlVuelos+ "/vuelos/{idVuelo}/{plazasReservadas}", null, idVuelo, plazasReservadas);
	}

	/**
	 * Obtiene una lista de reservas de un hotel con el nombre especificado, comprobando que exista 
	 * luego obtiene el ID del dicho hotel existente para poder listar las reservas asociadas a su ID.
	 * 
	 * @param nomHotel El nombre del hotel del que se desea obtener la lista de reservas.
	 * @return Una lista de objetos de tipo Reserva.
	 */
	@Override
	public List<Reserva> listaReservasDeUnHotel(String nomHotel) {
		//aqui metodo primero comprobar si existe un hotel con ese nombre
		if(existeHotelConNombre(nomHotel)) {
			System.out.println("Existe un hotel con ese nombre");
			Integer idHotel = idReservaDeHotel(nomHotel);
			return dao.getHotelReservationsList(idHotel);
		}else {
			System.out.println("No existen reservas con ese nombre del Hotel");
			return null;
		}

	}
	
	/**
	 * Verifica si existe un hotel con el nombre especificado.
	 * 
	 * @param nomHotel El nombre del hotel a verificar.
	 * @return true si existe un hotel con el nombre especificado, false de lo contrario.
	 */
	private boolean existeHotelConNombre(String nomHotel) {
		return Boolean.parseBoolean(restTemplate.getForObject(urlHotel + "/hoteles/reserva/nombrehotel/{nomHotel}", String.class, nomHotel));
	}
	
	/**
	 * Obtiene el ID de un hotel con el nombre especificado.
	 * 
	 * @param nomHotel El nombre del hotel del que se desea obtener el ID.
	 * @return El ID del hotel especificado.
	 */
	private Integer idReservaDeHotel(String nomHotel) {
		Integer idHotel =  Integer.parseInt(restTemplate.getForObject(urlHotel + "/hoteles/reserva/id/{nomHotel}", String.class, nomHotel));
		return idHotel;
	}

}
