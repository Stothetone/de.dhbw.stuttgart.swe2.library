package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ObjectInformation extends AbstractIdentifiable {
	
	private String name;
	
	@ManyToMany(targetEntity = Publisher.class)
	private List<Publisher> publishers;
	
	@OneToMany(targetEntity = LendingObject.class)
	private List<LendingObject> lendingObjects;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Publisher> getPublisher() {
		return publishers;
	}

	public void setPublisher(List<Publisher> publishers) {
		this.publishers = publishers;
	}

	public List<LendingObject> getLendingObjects() {
		return lendingObjects;
	}

	public void setLendingObjects(List<LendingObject> lendigObjects) {
		this.lendingObjects = lendigObjects;
	}

}
