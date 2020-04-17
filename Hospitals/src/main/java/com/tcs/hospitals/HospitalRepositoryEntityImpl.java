package com.tcs.hospitals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepositoryEntityImpl implements HospitalRepository {
	
	@Autowired
	private EntityManager entityManager; 

	@Override
	public <S extends Hospital> S save(S entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public <S extends Hospital> Iterable<S> saveAll(Iterable<S> entities) {
		entities.forEach(h -> entityManager.persist(h));
		return entities;
	}

	@Override
	public Optional<Hospital> findById(Integer id) {
		Hospital hospital = entityManager.find(Hospital.class, id);
		List<Hospital> list = new ArrayList<Hospital>();
		if(hospital != null) {
			list.add(hospital);
		}
		return list.stream().findFirst();
	}

	@Override
	public boolean existsById(Integer id) {
		Hospital hospital = entityManager.find(Hospital.class, id);
		return hospital != null;
	}

	@Override
	public Iterable<Hospital> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Hospital> criteriaQuery = criteriaBuilder.createQuery(Hospital.class);
		Root<Hospital> root = criteriaQuery.from(Hospital.class);
		criteriaQuery = criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Iterable<Hospital> findAllById(Iterable<Integer> ids) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Hospital> criteriaQuery = criteriaBuilder.createQuery(Hospital.class);
		Root<Hospital> root = criteriaQuery.from(Hospital.class);
		In<Integer> inClause = criteriaBuilder.in(root.get("id"));
		ids.forEach(id -> inClause.value(id));
		criteriaQuery = criteriaQuery.select(root).where(inClause);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public long count() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Hospital> root = criteriaQuery.from(Hospital.class);
		criteriaQuery = criteriaQuery.select(criteriaBuilder.count(root));
		return entityManager.createQuery(criteriaQuery).getResultList().stream().findFirst().get();
	}

	@Override
	public void deleteById(Integer id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Hospital> criteriaDelete = criteriaBuilder.createCriteriaDelete(Hospital.class);
		Root<Hospital> root = criteriaDelete.from(Hospital.class);
		criteriaDelete = criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	@Override
	public void delete(Hospital entity) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Hospital> criteriaDelete = criteriaBuilder.createCriteriaDelete(Hospital.class);
		Root<Hospital> root = criteriaDelete.from(Hospital.class);
		criteriaDelete = criteriaDelete.where(criteriaBuilder.equal(root.get("id"), entity.getId()));
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	@Override
	public void deleteAll(Iterable<? extends Hospital> entities) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Hospital> criteriaDelete = criteriaBuilder.createCriteriaDelete(Hospital.class);
		Root<Hospital> root = criteriaDelete.from(Hospital.class);
		In<Integer> inClause = criteriaBuilder.in(root.get("id"));
		entities.forEach(entity -> inClause.value(entity.getId()));
		criteriaDelete = criteriaDelete.where(inClause);
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	@Override
	public void deleteAll() {
		entityManager.clear();
	}

}
