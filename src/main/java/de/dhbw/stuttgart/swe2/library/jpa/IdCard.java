package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class IdCard extends AbstractIdentifiable {
	
	private Date validUntil;
	
	@OneToOne(targetEntity = Customer.class)
	private Customer customer;

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
