package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

public abstract class ObjectInformation extends AbstractIdentifiable {
	
	private String name;
	private List<Publisher> publishers;
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
