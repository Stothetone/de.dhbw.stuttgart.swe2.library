package de.dhbw.stuttgart.swe2.library.jpa;

import javax.persistence.Entity;

@Entity
public abstract class Multimedia extends ObjectInformation {
	
	private Integer numberOfDiscs;
	private String genre;
	private float duration;
	
	public Integer getNumberOfDisks() {
		return numberOfDiscs;
	}
	public void setNumberOfDisks(Integer numberOfDiscs) {
		this.numberOfDiscs = numberOfDiscs;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
}
