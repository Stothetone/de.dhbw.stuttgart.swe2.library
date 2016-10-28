package de.dhbw.stuttgart.swe2.library.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import de.dhbw.stuttgart.swe2.Identifiable;

@MappedSuperclass
public class AbstractIdentifiable implements Identifiable {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public AbstractIdentifiable() {
		super();
	}

	public long getId() {
		return id;
	}

}