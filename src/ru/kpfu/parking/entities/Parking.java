package ru.kpfu.parking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parking {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Parking(String name) {
		this.name = name;
	}
}
