package com.tcs.hospitals;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class HospitalRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private HospitalRepository hospitalRepository;

	@Test
	public void testFindById() {
		entityManager.persist(new Hospital(1003,"Vcare Hospital","Mumbai",3.1));
		Hospital hospital = hospitalRepository.findById(1003).get();
		assertEquals("Vcare Hospital", hospital.getName());
	}

}
