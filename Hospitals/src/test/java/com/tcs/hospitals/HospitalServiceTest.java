package com.tcs.hospitals;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HospitalServiceTest {
	
	@Mock
	private HospitalRepository hospitalRepositoryMock;
	
	@InjectMocks
	private HospitalService hosdpitalService;

	@Test
	public void testGetAllHospitals() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		List<Hospital> expectedList = Arrays.asList(first,second);
		when(hospitalRepositoryMock.findAll()).thenReturn(Arrays.asList(first,second));
		List<Hospital> hospitals = hosdpitalService.getAllHospitals();
		assertEquals(expectedList.size(), hospitals.size());
		for(int i = 0;i<expectedList.size();i++) {
			Hospital expected = expectedList.get(i);
			Hospital actual = hospitals.get(i);
			assertEquals(expected.getId(), actual.getId());
			assertEquals(expected.getName(), actual.getName());
			assertEquals(expected.getCity(), actual.getCity());
			assertEquals(expected.getRating(), actual.getRating(),0.01);
		}
	}

	@Test
	public void testGetHospital() {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		when(hospitalRepositoryMock.findById(anyInt())).thenReturn(Optional.of(hospital));
		Hospital actual = hosdpitalService.getHospital(1000);
		assertEquals(hospital.getId(), actual.getId());
		assertEquals(hospital.getName(), actual.getName());
		assertEquals(hospital.getCity(), actual.getCity());
		assertEquals(hospital.getRating(), actual.getRating(),0.01);
	}

	@Test
	public void testInsertHospital() {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		when(hospitalRepositoryMock.save(any(Hospital.class))).thenReturn(hospital);
		hosdpitalService.insertHospital(hospital);
	}

	@Test
	public void testUpdateHospital() {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		when(hospitalRepositoryMock.save(any(Hospital.class))).thenReturn(hospital);
		hosdpitalService.updateHospital(hospital);
	}

	@Test
	public void testDeleteHospital() {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		doNothing().when(hospitalRepositoryMock).delete(hospital);
		hosdpitalService.deleteHospital(hospital);
	}

}
