Actúa sobre una tabla de vuelos con los siguientes campos: idVuelo (autonumérico), compañia, 
fechaVuelo, precio y plazas disponibles. 

Expone dos recursos: 
	 Un recurso que devuelve la lista de vuelos disponibles al recibir una petición get. La
URL incluye el total de plazas que se pretenden reservar y se deberán devolver los
datos de los vuelos que tengan plazas suficientes para dicho valor
	 Un recurso que al recibir una petición put actualiza los datos del vuelo indicado. Recibe
en la url el idVuelo y las plazas reservadas