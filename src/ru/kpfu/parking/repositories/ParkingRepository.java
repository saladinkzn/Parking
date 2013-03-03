package ru.kpfu.parking.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.kpfu.parking.entities.Parking;

@Repository
public class ParkingRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	public List<Parking> getAll() {
		final EntityManager entityManager = createEntityManager();
		try {
			// TODO: транзакции
			
			final TypedQuery<Parking> selectAllQuery = entityManager.createQuery("select p from Parking p", Parking.class);
			final List<Parking> resultList = selectAllQuery.getResultList();
			return resultList;
		} finally {
			entityManager.close();
		}
	}


	public void save(Parking parking) {
		final EntityManager entityManager = createEntityManager();
		try {
			if(parking.getId() != null) {
				entityManager.persist(parking);
			} else {
				entityManager.merge(parking);
			}
		} finally {
			entityManager.close();
		}
		
	}


	private EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
