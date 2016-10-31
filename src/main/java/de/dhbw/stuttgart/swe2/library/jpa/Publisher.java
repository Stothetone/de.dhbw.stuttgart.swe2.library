package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Publisher extends AbstractIdentifiable {
	
	private String name;
	
	@ManyToMany(targetEntity = ObjectInformation.class)
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
