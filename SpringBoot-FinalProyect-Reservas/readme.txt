
Utiliza una tabla de reservas con los siguientes campos: idReserva(autonumérico), 
nombreCliente, dni, idHotel e idVuelo. Tendrá los siguientes recursos 

	 Expone un recurso que ante una petición de tipo post, que recibe en el cuerpo de la
	misma un objeto JSON con el identificador vuelo, identificador hotel, nombre, dni y
	total de personas que forman la reserva, registrará la misma en la base de datos.
	Interacciona con el servicio de vuelos para actualizar las plazas disponibles al realizar la
	reserva.
	
	 Dispondrá de otro recurso que, ante una petición get, devolverá las reservas existentes 
	(nombre, dni, vuelo), para el nombre hotel recibido como variable en url. Deberá 
	interaccionar con el servicio de hoteles para conocer el idHotel a partir de su nombre.