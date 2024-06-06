package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * La clase ReservaDto representa una transferencia de datos de una reserva, añadiendo el atributo plazasReservadas
 * para el correcto funcionamiento del servicio.
 */
public class ReservaDto {
	
	private int idReserva;
	private String nombreCliente;
	private String dni;
	private int idHotel;
	private int idVuelo;
	private int plazasReservadas;
	
	public ReservaDto() {
		super();
	}
	

	public ReservaDto( String nombreCliente, String dni, int idHotel, int idVuelo, int plazasReservadas) {
		super();
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.plazasReservadas = plazasReservadas;
	}

	
	public int getPlazasReservadas() {
		return plazasReservadas;
	}

	public void setPlazasReservadas(int plazasReservadas) {
		this.plazasReservadas = plazasReservadas;
	}

	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public int getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaDto other = (ReservaDto) obj;
		return idReserva == other.idReserva;
	}
	
	
}
