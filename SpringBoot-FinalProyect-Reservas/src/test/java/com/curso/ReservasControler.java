package com.curso;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Reserva;
import com.curso.model.ReservaDto;
import com.curso.service.ReservasService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class ReservasControler {

	@Autowired
	private MockMvc mock;
	
	//crea un objeto simulado de ReservaService
	@MockBean
	ReservasService service;
	
	// Objeto para convertir objetos Java a JSON
	@Autowired
    private ObjectMapper objectMapper; 

	@Test 
	public void createReservaWithPathVariable() throws Exception{
		
		ReservaDto reservaDto = new ReservaDto();
		//transformamos el objeto a un formato JSON
		String reservaDtoJson= objectMapper.writeValueAsString(reservaDto);
		
		doNothing().when(service).insertReserva(any(ReservaDto.class));
	     mock.perform(post("/reservas")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(reservaDtoJson))
	                .andExpect(status().isOk());
	}
}
