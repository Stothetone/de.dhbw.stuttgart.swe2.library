package de.dhbw.stuttgart.swe2.library.jpa;

import javax.persistence.Entity;

@Entity
public class Movie extends Multimedia {
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
