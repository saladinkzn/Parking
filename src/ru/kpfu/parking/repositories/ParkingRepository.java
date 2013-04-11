package ru.kpfu.parking.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.kpfu.parking.entities.Parking;

/**
 * Пример класса для взаимодействия с хранилищем.
 * 
 * Обратите внимание: 1. Аннотация @Repository на классе. Она подсказывает
 * Spring'у, что данный класс можно использовать как зависимость. 2. Аннотация @Autowired
 * на поле EntityManagerFactory entityManagerFactory. Она говорит Spring'у:
 * "вставть в это поле зависимость с типом EntityManagerFactory. Таким образом
 * мы получаем нужную нам для работы фабрику, при этом сам класс не знает о том,
 * как она создается.
 * 
 * @author Timur
 */
@Repository
public class ParkingRepository {
	/**
	 * Фабрика EntityManager'ов, создает EntityManager'ы - объекты для работы с
	 * БД GoogleApplicationEngine.
	 */
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	/**
	 * Метод, получает все парковки.
	 * 
	 * @return Список всех добавленных парковок.
	 */
	public List<Parking> getAll() {
		// Получаем объект типа EntityManager
		final EntityManager entityManager = createEntityManager();
		try {
			// TODO: транзакции
			// Создаем запрос (похож на SQL, но это не SQL, а JPQL), который
			// возвращает нам список всех парковок
			final TypedQuery<Parking> selectAllQuery = entityManager
					.createQuery("select p from Parking p", Parking.class);
			// Исполняем запрос, получаем результат
			final List<Parking> resultList = selectAllQuery.getResultList();
			// Возвращаем результат
			return resultList;
		} finally {
			entityManager.close();
		}
	}

	/**
	 * Метод получает все парковки, прошедшие модерацию
	 * 
	 */
	public List<Parking> getAllModerated() {
		return getParkings(true);
	}

	private List<Parking> getParkings(boolean moderated) {
		final EntityManager entityManager = createEntityManager();
		try {
			final TypedQuery<Parking> selectAllModerated = entityManager
					.createQuery(
							"select p from Parking p where p.moderated = :moderated",
							Parking.class);

			selectAllModerated.setParameter("moderated", moderated);
			return selectAllModerated.getResultList();
		} finally {
			entityManager.close();
		}
	}

	public List<Parking> getAllNotModerated() {
		return getParkings(false);
	}

	public void setModerated(Parking parking) {
		final EntityManager entityManager = createEntityManager();
		try {
			parking.setModerated(true);
			entityManager.merge(parking);
		} finally {
			entityManager.close();
		}
	}

	public void deleteParking(Parking parking) {
		final EntityManager entityManager = createEntityManager();
		try {
			final Parking merge = entityManager.merge(parking);
			entityManager.remove(merge);
		} finally {
			entityManager.close();
		}
	}

	public Parking getById(Long id) {
		final EntityManager entityManager = createEntityManager();
		try {
			return entityManager.find(Parking.class, id);
		} finally {
			entityManager.close();
		}
	}

	/**
	 * Сохраняет парковку, добавляя её, если она еще не добавлена.
	 * 
	 * @param parking
	 *            Парковка, которая должна быть обновлена/добавлена.
	 */
	public void save(Parking parking) {
		// Получаем объект типа EntityManager
		final EntityManager entityManager = createEntityManager();
		try {
			if (parking.getId() == null) {
				// Если новая - вставляем
				entityManager.persist(parking);
			} else {
				// Если существует - обновляет
				entityManager.merge(parking);
			}
		} finally {
			entityManager.close();
		}

	}

	/**
	 * Метод, инкапсулирующий получение EntityManager
	 * 
	 * @return EntityManager.
	 */
	private EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
