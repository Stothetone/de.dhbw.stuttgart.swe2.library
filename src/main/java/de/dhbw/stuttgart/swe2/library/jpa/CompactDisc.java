package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

public class CompactDisc extends Multimedia {

	private Integer numberOfTitles;
	private List<Title> titles;

	// shouldn't this be a derived attribute?? titles.size() ??
	public Integer getNumberOfTitles() {
		return numberOfTitles;
	}

	public void setNumberOfTitles(Integer numberOfTitles) {
		this.numberOfTitles = numberOfTitles;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}
}
