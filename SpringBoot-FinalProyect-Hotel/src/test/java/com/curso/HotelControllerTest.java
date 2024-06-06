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

import com.curso.model.Hotel;
import com.curso.service.HotelService;

@SpringBootTest
@AutoConfigureMockMvc
class HotelControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private HotelService service;

	@BeforeEach
	public void setUp() {
		// Inicializar un hotel simulado con ID 1 antes de cada prueba
		Hotel simulatedHotel = new Hotel(1, "Hotel Simulado","Categoría Simulada",100.00,true);
		when(service.existsHotelId(1)).thenReturn(true);
	}

	@Test
	public void getExistsHotelWithId1() throws Exception{
		int idHotel = 1;
		mock.perform(get("/hoteles/id/{idHotel}", idHotel))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE +  ";charset=UTF-8"))
		.andExpect(content().string(String.valueOf(true)));

	}


}
