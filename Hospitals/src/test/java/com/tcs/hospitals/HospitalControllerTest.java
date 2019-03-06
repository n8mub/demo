package com.tcs.hospitals;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HospitalControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private HospitalService hospitalServiceMock;
	
	@Autowired
	WebApplicationContext context;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testGetAllHospitals() throws Exception {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		when(hospitalServiceMock.getAllHospitals()).thenReturn(Arrays.asList(first,second));
		mockMvc.perform(get("/test/hospitals")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isArray())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id").value(1000))
			.andExpect(jsonPath("$[0].name").value("Test Hospital"))
			.andExpect(jsonPath("$[0].city").value("Chennai"))
			.andExpect(jsonPath("$[0].rating").value(3.8))
			.andExpect(jsonPath("$[1].id").value(1003))
			.andExpect(jsonPath("$[1].name").value("Vcare Hospital"))
			.andExpect(jsonPath("$[1].city").value("Mumbai"))
			.andExpect(jsonPath("$[1].rating").value(3.1));
	}

	@Test
	public void testGetHospital() throws Exception {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		when(hospitalServiceMock.getHospital(anyInt())).thenReturn(hospital);
		mockMvc.perform(get("/test/hospitals/1000")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1000))
			.andExpect(jsonPath("$.name").value("Test Hospital"))
			.andExpect(jsonPath("$.rating").value(3.8))
			.andExpect(jsonPath("$.city").value("Chennai"));
	}

	@Test
	public void testInsertHospital() throws Exception {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		mockMvc.perform(post("/test/hospitals",hospital)).andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void testUpdateHospital() throws Exception {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		mockMvc.perform(put("/test/hospitals",hospital)).andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void testDeleteHospital() throws Exception {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		mockMvc.perform(post("/test/hospitals",hospital)).andDo(print())
			.andExpect(status().isOk());
		mockMvc.perform(delete("/test/hospitals",hospital)).andDo(print())
			.andExpect(status().isNoContent());
	}

}
