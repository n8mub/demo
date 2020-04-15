package com.tcs.hospitals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HospitalsRepositoryImpl implements HospitalRepository {
	
	private List<Hospital> hospitals = new ArrayList<>();

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
		List<Hospital> matchs = new ArrayList<Hospital>();
		ids.forEach(id -> {
			Hospital hospital = hospitals.stream().filter(h -> id.compareTo(h.getId()) == 0).findFirst().get();
			matchs.add(hospital);
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
