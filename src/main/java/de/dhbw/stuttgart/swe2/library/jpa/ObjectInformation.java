package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public abstract class ObjectInformation extends AbstractIdentifiable {
	
	private String name;
	
	@ManyToMany(targetEntity = Publisher.class)
	private List<Publisher> publishers;
	
	@OneToMany(targetEntity = LendingObject.class)
	private List<LendingObject> lendigObjects;

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

	public List<LendingObject> getLendigObjects() {
		return lendigObjects;
	}

	public void setLendigObjects(List<LendingObject> lendigObjects) {
		this.lendigObjects = lendigObjects;
	}

}
