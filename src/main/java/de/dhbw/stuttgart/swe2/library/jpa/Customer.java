package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends Person {

	private boolean active;
	
	@OneToMany(targetEntity = LendingInformation.class)
	private List<LendingInformation> lendingInfo;
	
	@OneToOne(targetEntity = IdCard.class, cascade = CascadeType.ALL, mappedBy = "customer")
	private IdCard idCard;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public List<LendingInformation> getLendingInfo() {
		return lendingInfo;
	}

	public void setLendingInfo(List<LendingInformation> lendingInfo) {
		this.lendingInfo = lendingInfo;
	}
}
