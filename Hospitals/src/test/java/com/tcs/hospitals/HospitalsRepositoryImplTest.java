package com.tcs.hospitals;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class HospitalsRepositoryImplTest {
	
	private HospitalsRepositoryImpl hospitalsRepository;

	@Before
	public void setUp() throws Exception {
		hospitalsRepository = new HospitalsRepositoryImpl();
	}

	@Test
	public void testSave() {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital actual = hospitalsRepository.save(hospital);
		assertEquals(hospital, actual);
	}

	@Test
	public void testSaveAll() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		List<Hospital> expectedList = Arrays.asList(first,second);
		List<Hospital> actualList = (List<Hospital>) hospitalsRepository.saveAll(expectedList);
		assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	@Test
	public void testFindById() {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		hospitalsRepository.save(hospital);
		Hospital actual = hospitalsRepository.findById(1000).get();
		assertEquals(hospital, actual);
	}

	@Test
	public void testExistsById() {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		hospitalsRepository.save(hospital);
		assertTrue(hospitalsRepository.existsById(1000));
	}

	@Test
	public void testFindAll() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		Set<Hospital> expectedList = new TreeSet<Hospital>(Arrays.asList(first, second));
		hospitalsRepository.saveAll(expectedList);
		Set<Hospital> actualList = (Set<Hospital>) hospitalsRepository.findAll();
		assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	@Test
	public void testFindAllById() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		Set<Hospital> expectedList = new TreeSet<Hospital>(Arrays.asList(first, second));
		hospitalsRepository.saveAll(expectedList);
		Set<Hospital> actualList = (Set<Hospital>) hospitalsRepository.findAllById(Arrays.asList(1000,1003));
		assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	@Test
	public void testCount() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		Set<Hospital> expectedList = new TreeSet<Hospital>(Arrays.asList(first, second));
		hospitalsRepository.saveAll(expectedList);
		assertEquals(2, hospitalsRepository.count());
	}

	@Test
	public void testDeleteById() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		Set<Hospital> expectedList = new TreeSet<Hospital>(Arrays.asList(first, second));
		hospitalsRepository.saveAll(expectedList);
		hospitalsRepository.deleteById(1000);
		assertFalse(hospitalsRepository.existsById(1000));
	}

	@Test
	public void testDelete() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		Set<Hospital> expectedList = new TreeSet<Hospital>(Arrays.asList(first, second));
		hospitalsRepository.saveAll(expectedList);
		hospitalsRepository.delete(first);
		assertFalse(hospitalsRepository.existsById(1000));
	}
	
	@Test
	public void testDeleteAllIterableOfextendsHospital() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		Set<Hospital> expectedList = new TreeSet<Hospital>(Arrays.asList(first, second));
		hospitalsRepository.saveAll(expectedList);
		hospitalsRepository.deleteAll(expectedList);
		assertFalse(hospitalsRepository.existsById(1000));
		assertFalse(hospitalsRepository.existsById(1003));
	}

	@Test
	public void testDeleteAll() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		Set<Hospital> expectedList = new TreeSet<Hospital>(Arrays.asList(first, second));
		hospitalsRepository.saveAll(expectedList);
		hospitalsRepository.deleteAll();
		Set<Hospital> actualList = (Set<Hospital>) hospitalsRepository.findAll();
		assertTrue(actualList.isEmpty());
	}
	
	@Test
	public void testEquals() {
		Hospital hospital = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital hospitaldup = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		List<Hospital> expectedList = Arrays.asList(hospital,hospitaldup);
		hospitalsRepository.saveAll(expectedList);
		assertEquals(2, expectedList.size());
		assertEquals(1, hospitalsRepository.count());
	}
	
	@Test
	public void testCompare() {
		Hospital first = new Hospital(1000, "Test Hospital", "Chennai", 3.8);
		Hospital second = new Hospital(1003,"Vcare Hospital","Mumbai",3.1);
		SortedSet<Hospital> expectedList = new TreeSet<Hospital>(Arrays.asList(first, second));
		hospitalsRepository.saveAll(expectedList);
		SortedSet<Hospital> actualList = (SortedSet<Hospital>) hospitalsRepository.findAll();
		assertEquals(first, actualList.first());
		assertEquals(second, actualList.last());
	}

}
