package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.Date;

public class IdCard extends AbstractIdentifiable {
	
	private Date validUntil;

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

}
