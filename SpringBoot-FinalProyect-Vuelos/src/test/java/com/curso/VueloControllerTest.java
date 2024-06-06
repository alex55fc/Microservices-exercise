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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Vuelo;
import com.curso.service.VueloService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
class VueloControllerTest {

	@Autowired
	private MockMvc mock;
	
	//crea un objeto simulado de VueloService
	@MockBean
	VueloService service;
	
	@BeforeEach
	public void setUp() {
		List<Vuelo> listaVuelos = new ArrayList<>();		
		listaVuelos.add(new Vuelo());
		when(service.vuelos()).thenReturn(listaVuelos);
	}
	
	@Test
	public void getAllFlyes() throws Exception{
		mock.perform(get("/vuelos"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$", hasSize(1)));
	}
	
}
