package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Artist extends AbstractIdentifiable {
	
	private String name;
	
	@ManyToMany(targetEntity = Title.class)
	private List<Title> titles;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Title> getTitles() {
		return titles;
	}
	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

}
