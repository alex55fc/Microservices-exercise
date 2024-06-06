# Agencia de viajes - API REST

Este repositorio contiene un proyecto centrado en una agencia de viajes. La aplicación integra tres entidades principales: `Hotel`, `Vuelos` y `Reservas`. Utiliza una base de datos MySQL y expone sus funcionalidades mediante una API REST.
## Características Principales

- Conexión a una base de datos MySQL.
- Implementación de operaciones CRUD para gestionar `Hotel`, `Vuelos` y `Reservas`.
- Exposición de endpoints para interactuar con las entidades.

##Clonar el repositorio:
Para comenzar, debes clonar este repositorio utilizando el siguiente comando:
  
   ```https://github.com/alex55fc/Microservices-exercise.git```


# Entidades

1. **Hotel**: Representa un establecimiento de hospedaje donde los clientes pueden reservar habitaciones para alojarse temporalmentes.
2. **Vuelos**: Representa un servicio de transporte aéreo que los clientes pueden reservar para viajar de un lugar a otro.
3. **Reservas**: Representa una reserva realizada por un cliente para un hotel o un vuelo en particular, que incluye detalles como el cliente, el hotel o vuelo reservado, y otros datos relevantes.

# Funcionalidades
1. **Listar los hoteles**
2. **Listar los hoteles de un nombre en especifico**
3. **Listar los vuelos con la capacidad de asientos libres especificada por parametro**
4. **Actualiza los asientos libres de un vuelo indicado por parametro**
5. **Inserta una reserva**
6. **Listar las reservas de un hotel por nombre**

## Endpoints 

### Hotel

1. **Listar los hoteles**
   - **URL**: `/hoteles`
   - **Método**: `GET`

2. **Listar los hoteles de un nombre en especifico**
   - **URL**: `/hoteles/{nomHotel}`
   - **Método**: `GET`


### Vuelos

1. **Listar los vuelos con la capacidad de asientos libres especificada por parametro**
   - **URL**: `/vuelos/{plazasReservadas}`
   - **Método**: `GET`
   - 
2. **Actualiza los asientos libres de un vuelo indicado por parametro**
   - **URL**: `/vuelos/{idVuelo}/{plazasReservadas}`
   - **Método**: `PUT`


### Reservas

1. **Inserta una reserva**
   - **URL**: `/reservas`
   - **Método**: `POST`

2. **Listar las reservas de un hotel por nombre**
   - **URL**: `/reservas/hotel/{nomHotel}`
   - **Método**: `GET`







 
  


   
