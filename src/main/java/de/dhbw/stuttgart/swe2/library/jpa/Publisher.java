package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

public class Publisher extends AbstractIdentifiable {
	
	private String name;
	private List<ObjectInformation> objectInformation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ObjectInformation> getObjectInformation() {
		return objectInformation;
	}
	public void setObjectInformation(List<ObjectInformation> objectInformation) {
		this.objectInformation = objectInformation;
	}

}
