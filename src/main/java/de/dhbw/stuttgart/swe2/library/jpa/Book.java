package de.dhbw.stuttgart.swe2.library.jpa;

import javax.persistence.Entity;

@Entity
public class Book extends PrintMedia {
	
	private String ISBN;
	private Integer edition;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}

}
