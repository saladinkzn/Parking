package ru.kpfu.parking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Пример класса, который хранится в БД GAE.
 * 
 * Обратите внимание:
 * 1. Аннотация @Entity. Говорит GAE, что объекты этого класса будут храниться в БД.
 */
/**
 * Парковка
 * 
 * @author Timur
 *
 */
@Entity
public class Parking {
	// @Id - означает, что данное поле будет использоваться в качестве первичного ключа (primary key)
	// @Column - означает, что данное поле должно быть сохранено в БД в виде столбца.
	// @GeneratedValue - означает, что значение данного поля генерируется БД.
	/**	
	 * Идентификатор парковки
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Адрес 
	 */
	@Column
	private String address;
	
	/**
	 * Широта
	 */
	@Column
	private double latitude;
	
	/**
	 * Долгота
	 */
	@Column
	private double longitude;
	
	/**
	 * Название парковки
	 */
	@Column(nullable = true)
	private String name;
	
	/**
	 * Режим работы
	 */
	@Column(nullable = true)
	private String workingPlan;
	
	/**
	 * Стоимость (За час)
	 */
	@Column(nullable = true)
	private Double pricing;
	
	/**
	 * Описание
	 */
	@Column
	private String description;
	
	/**
	 * Одобрено ли модератором
	 */
	@Column 
	private boolean moderated;
	
	/**
	 * Создает парковки
	 * 
	 * @param address Адрес
	 * @param latitude Широта
	 * @param longitude Долгота
	 */
	public Parking(String address, double latitude, double longitude) {
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moderated = false;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Широта
	 */

	public double getLatitude() {
		return latitude;
	}
	/**
	 * Широта
	 */

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * Долгота
	 */

	public double getLongitude() {
		return longitude;
	}
	/**
	 * Долгота
	 */

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkingPlan() {
		return workingPlan;
	}

	public void setWorkingPlan(String workingPlan) {
		this.workingPlan = workingPlan;
	}

	public Double getPricing() {
		return pricing;
	}

	public void setPricing(Double pricing) {
		this.pricing = pricing;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pricing == null) ? 0 : pricing.hashCode());
		result = prime * result
				+ ((workingPlan == null) ? 0 : workingPlan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parking other = (Parking) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pricing == null) {
			if (other.pricing != null)
				return false;
		} else if (!pricing.equals(other.pricing))
			return false;
		if (workingPlan == null) {
			if (other.workingPlan != null)
				return false;
		} else if (!workingPlan.equals(other.workingPlan))
			return false;
		return true;
	}


	public void setModerated(boolean b) {
		this.moderated = true;
	}

	
}
