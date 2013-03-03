package ru.kpfu.parking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Пример класса, который хранится в БД GAE.
 * 
 * Обратите внимание:
 * 1. Аннотация @Entity. Говорит GAE, что объекты этого класса будут храниться в БД.
 */
@Entity
public class Parking {
	/**
	 * @Id - означает, что данное поле будет использоваться в качестве первичного ключа (primary key)
	 * @Column - означает, что данное поле должно быть сохранено в БД в виде столбца.
	 * @GeneratedValue - означает, что значение данного поля генерируется БД.
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * @Column - означает, что данное поле должно быть сохранено в БД в виде столбца.
	 */
	@Column
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	protected Parking() {
		
	}

	public Parking(String name) {
		this.name = name;
	}
}
