package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelDao;
import com.curso.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired 
	HotelDao dao;

	@Override
	public List<Hotel> hoteles() {
		return dao.findAll();
	}

	/**
	 * Devuelve los datos del hotel con el nombre especificado. 
	 *   
	 * @param nomHotel El nombre del hotel del que se desea obtener los datos.
	 * @return objeto Hotel con los datos especificados, o null si no se encuentra un hotel con dicho nombre.
	 */
	
	@Override
	public Hotel datosHotel(String nomHotel) {
		return dao.obtainHotelByHotelName(nomHotel);
	}
	
	/**
	 * Verifica si un hotel con el ID especificado existe en la base de datos.
	 * 
	 * @param idHotel El ID del hotel que se desea verificar.
	 * @return true si existe un hotel con el ID especificado, false de lo contrario.
	 */
	@Override
	public Boolean existsHotelId(int idHotel) {
		return dao.findById(idHotel).isPresent();
	}
	
	/**
	 * Devuelve el ID de un hotel específico utilizando su nombre.
	 * 
	 * @param nomHotel El nombre del hotel del que se desea obtener el ID.
	 * @return El ID del hotel especificado, o null si no se encuentra.
	 */
	@Override
	public Integer devuelveIdHotelByNombreHotel(String nomHotel) {
		return dao.obtainHotelIdByHotelName(nomHotel);
	}


	/**
	 * Verifica si existe un hotel con el nombre especificado en la base de datos.
	 * 
	 * @param nomHotel El nombre del hotel que se desea verificar.
	 * @return true si existe un hotel con el nombre especificado, false de lo contrario.
	 */
	@Override
	public Boolean existsHotelByName(String nomHotel) {
		return dao.existsHotelByHotelName(nomHotel);
	}



}
