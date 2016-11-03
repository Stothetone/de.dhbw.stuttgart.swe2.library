package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LendingObject extends AbstractIdentifiable {

	@OneToMany(targetEntity = LendingInformation.class)
	private List<LendingInformation> lendingInfo;
	
	@ManyToMany(targetEntity = Library.class)
	private List<Library> libraries;
	
	@ManyToOne(targetEntity = ObjectInformation.class)
	private ObjectInformation objectInformation;

	@OneToMany(targetEntity = LendingInformation.class)
	public List<LendingInformation> getLendingInfo() {
		return lendingInfo;
	}

	public void setLendingInfo(List<LendingInformation> lendingInfo) {
		this.lendingInfo = lendingInfo;
	}

	public ObjectInformation getObjectInformation() {
		return objectInformation;
	}

	public void setObjectInformation(ObjectInformation objectInformation) {
		this.objectInformation = objectInformation;
	}
}
