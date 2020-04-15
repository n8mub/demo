package com.tcs.hospitals;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

@Repository
public class HospitalsRepositoryImpl implements HospitalRepository {
	
	private Set<Hospital> hospitals = new TreeSet<Hospital>();

	@Override
	public <S extends Hospital> S save(S entity) {
		hospitals.add(entity);
		return entity;
	}

	@Override
	public <S extends Hospital> Iterable<S> saveAll(Iterable<S> entities) {
		entities.forEach(e -> hospitals.add(e));
		return entities;
	}

	@Override
	public Optional<Hospital> findById(Integer id) {
		return hospitals.stream().filter(h -> id.compareTo(h.getId()) == 0).findFirst();
	}

	@Override
	public boolean existsById(Integer id) {
		return hospitals.stream().anyMatch(h -> id.compareTo(h.getId()) == 0);
	}

	@Override
	public Iterable<Hospital> findAll() {
		return hospitals;
	}

	@Override
	public Iterable<Hospital> findAllById(Iterable<Integer> ids) {
		Set<Hospital> matchs = new TreeSet<Hospital>();
		ids.forEach(id -> {
			Optional<Hospital> optional = hospitals.stream().filter(h -> id.compareTo(h.getId()) == 0).findFirst();
			if(optional.isPresent()) {
				Hospital hospital = optional.get();
				matchs.add(hospital);
			}
		});
		return matchs;
	}

	@Override
	public long count() {
		return hospitals.size();
	}

	@Override
	public void deleteById(Integer id) {
		hospitals.removeIf(h -> id.compareTo(h.getId()) == 0);
	}

	@Override
	public void delete(Hospital entity) {
		hospitals.remove(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Hospital> entities) {
		entities.forEach(e -> hospitals.remove(e));
	}

	@Override
	public void deleteAll() {
		hospitals.clear();
	}

}
